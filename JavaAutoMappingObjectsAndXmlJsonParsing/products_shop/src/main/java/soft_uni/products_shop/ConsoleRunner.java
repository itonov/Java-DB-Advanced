package soft_uni.products_shop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import soft_uni.products_shop.io.FileOutput;
import soft_uni.products_shop.models.dto.binding.categories.CategoryBindingModel;
import soft_uni.products_shop.models.dto.binding.categories.CategoryBindingModelXml;
import soft_uni.products_shop.models.dto.binding.products.ProductBindingModel;
import soft_uni.products_shop.models.dto.binding.products.ProductXmlDto;
import soft_uni.products_shop.models.dto.binding.users.UserBindingModel;
import soft_uni.products_shop.models.dto.binding.users.UserBindingModelXml;
import soft_uni.products_shop.models.dto.views.product.ProductViewModel;
import soft_uni.products_shop.models.dto.views.product.ProductViewModelSeparateNames;
import soft_uni.products_shop.models.dto.views.user.UserViewModel;
import soft_uni.products_shop.models.entities.Category;
import soft_uni.products_shop.models.entities.Product;
import soft_uni.products_shop.models.entities.User;
import soft_uni.products_shop.services.category.CategoryService;
import soft_uni.products_shop.services.product.ProductService;
import soft_uni.products_shop.services.user.UserService;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@Transactional
public class ConsoleRunner implements CommandLineRunner {

    private static final String CATEGORIES_JSON_PATH = "src/main/resources/jsoninput/categories.json";
    private static final String USERS_JSON_PATH = "src/main/resources/jsoninput/users.json";
    private static final String PRODUCTS_JSON_PATH = "src/main/resources/jsoninput/products.json";

    private static final String CATEGORIES_XML_PATH = "src/main/resources/xmlinput/categories.xml";
    private static final String USERS_XML_PATH = "src/main/resources/xmlinput/users.xml";
    private static final String PRODUCTS_XML_PATH = "src/main/resources/xmlinput/products.xml";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ConsoleRunner(UserService userService,
                         CategoryService categoryService,
                         ProductService productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.modelMapper = new ModelMapper();
        this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    }

    @Override
    public void run(String... args) throws Exception {
//        seedCategoriesFromJson();
//        seedUsersFromJson();
//        seedProductsFromJson();

//        jsonExportProductsInRange();
//        jsonExportUserSellers();

//        seedCategoriesFromXml();
//        seedUsersFromXml();

        xmlExportProducts();
    }

    private void xmlExportProducts() throws JAXBException, FileNotFoundException {
        ProductXmlDto productXmlDto = new ProductXmlDto();
        productXmlDto.setProducts(this.productService.getAll().stream()
                .map(p -> this.modelMapper.map(p, ProductViewModelSeparateNames.class))
                .collect(Collectors.toList()));
        JAXBContext context = JAXBContext.newInstance(ProductXmlDto.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        OutputStream os = new FileOutputStream(System.getProperty("user.dir") + "/src/main/resources/xmloutput/products-output.xml");
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os));
        marshaller.marshal(productXmlDto, bfw);
    }

    private void seedUsersFromXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(UserBindingModelXml.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        UserBindingModelXml userBindingModelXml = (UserBindingModelXml) unmarshaller.unmarshal(new File(USERS_XML_PATH));
        List<User> users = userBindingModelXml.getUsers()
                .stream()
                .map(u -> this.modelMapper.map(u, User.class))
                .collect(Collectors.toList());
        this.userService.save(users);
    }

    private void seedCategoriesFromXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CategoryBindingModelXml.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CategoryBindingModelXml categoryBindingModelXml = (CategoryBindingModelXml) unmarshaller.unmarshal(new File(CATEGORIES_XML_PATH));

        List<Category> categories = categoryBindingModelXml.getCategories()
                .stream()
                .map(c -> this.modelMapper.map(c, Category.class))
                .collect(Collectors.toList());
        this.categoryService.save(categories);
    }

    private void jsonExportUserSellers() throws IOException {
        List<User> users = this.userService.getAllSellersWithBuyer();
        List<UserViewModel> userViewModels = users.stream()
                .map( u -> this.modelMapper.map(u, UserViewModel.class))
                .collect(Collectors.toList());
        String json = this.gson.toJson(userViewModels);
        FileOutput.writeToFile("seller-products.json", json);
    }

    private void jsonExportProductsInRange() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        BigDecimal start = new BigDecimal(input[0]);
        BigDecimal end = new BigDecimal(input[1]);
        List<Product> products = this.productService.productsInRangeWithoutBuyer(start, end);

        Converter<User, String> nameConverter =
                src -> src.getSource().getFirstName() == null ? src.getSource().getLastName() :
                        src.getSource().getFirstName() + " " + src.getSource().getLastName();
        TypeMap<Product, ProductViewModel> typeMap = this.modelMapper.createTypeMap(Product.class, ProductViewModel.class)
                .addMappings(mapper ->
                        mapper.using(nameConverter).map(Product::getSeller, ProductViewModel::setSellerFullName));

        List<ProductViewModel> productViewModels = products.stream().map(typeMap::map).collect(Collectors.toList());
        String json = this.gson.toJson(productViewModels);
        FileOutput.writeToFile("products-in-range.json", json);
    }

    private void seedProductsFromJson() throws FileNotFoundException {
        InputStream is = new FileInputStream(PRODUCTS_JSON_PATH);
        JsonReader reader = this.gson.newJsonReader(new BufferedReader(new InputStreamReader(is)));
        ProductBindingModel[] productBindingModels = this.gson.fromJson(reader, ProductBindingModel[].class);
        List<Product> products = Arrays.stream(productBindingModels)
                .map(p -> this.modelMapper.map(p, Product.class))
                .collect(Collectors.toList());

        List<Category> categories = this.categoryService.getAll();
        List<User> users = this.userService.allUsers();
        Random random = new Random();
        products.forEach(p -> {
            p.getCategories().add(categories.get(random.nextInt(categories.size())));
            p.getCategories().add(categories.get(random.nextInt(categories.size())));
            p.getCategories().add(categories.get(random.nextInt(categories.size())));

            p.setBuyer(this.userService.findUser((long) random.nextInt(users.size() + 10)));
            p.setSeller(this.userService.findUser((long) random.nextInt(users.size() + 1)));
        });

        this.productService.save(products);
    }

    private void seedUsersFromJson() throws FileNotFoundException {
        InputStream is = new FileInputStream(USERS_JSON_PATH);
        JsonReader reader = this.gson.newJsonReader(new BufferedReader(new InputStreamReader(is)));
        UserBindingModel[] userBindingModels = this.gson.fromJson(reader, UserBindingModel[].class);
        List<User> users = Arrays.stream(userBindingModels)
                .map(u -> this.modelMapper.map(u, User.class))
                .collect(Collectors.toList());
        this.userService.save(users);
    }

    private void seedCategoriesFromJson() throws FileNotFoundException {
        InputStream is = new FileInputStream(CATEGORIES_JSON_PATH);
        JsonReader reader = this.gson.newJsonReader(new BufferedReader(new InputStreamReader(is)));
        CategoryBindingModel[] categoryBindingModels = gson.fromJson(reader, CategoryBindingModel[].class);
        List<Category> categories = Arrays.stream(categoryBindingModels)
                .map(c -> this.modelMapper.map(c, Category.class))
                .collect(Collectors.toList());
        this.categoryService.save(categories);
    }
}
