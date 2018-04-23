package app;

import app.services.IngredientService;
import app.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@Transactional
public class ConsoleRunner implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... strings) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String inputSize = reader.readLine();
//        Size size = Size.valueOf(inputSize.toUpperCase());
//        this.shampooService.getAllShampoosWithSizeOrderedById(size)
//                .forEach(s -> System.out.println(s.getBrand() + " " + size.toString() + " " + s.getPrice() + "lv."));

//        String[] inputTokens = reader.readLine().split(" ");
//        Size size = Size.valueOf(inputTokens[0].toUpperCase());
//        long id = Long.parseLong(inputTokens[1]);
//        this.shampooService.getAllShampoosBySizeOrLabelId(size, id)
//                .forEach(s -> System.out.println(s.getBrand() + " " + size.toString() + " " + s.getPrice() + "lv."));

//        BigDecimal neededPrice = new BigDecimal(reader.readLine());
//        this.shampooService.getShampoosWithPriceHigherThan(neededPrice)
//                .forEach(s -> System.out.println(s.getBrand() + " " + s.getSize().toString() + " " + s.getPrice() + "lv."));

//        String nameStart = reader.readLine();
//        this.ingredientService.getIngredientsWithNameStarting(nameStart).forEach(i -> System.out.println(i.getName()));

//        List<String> inputNames = new ArrayList<>();
//        String name = reader.readLine();
//        while (!"".equalsIgnoreCase(name)) {
//            inputNames.add(name);
//            name = reader.readLine();
//        }
//        this.ingredientService.getIngredientsByNamesStarting(inputNames).forEach(i -> System.out.println(i.getName()));

//        BigDecimal price = new BigDecimal(reader.readLine());
//        System.out.println(this.shampooService.countByPriceLowerThan(price));

//        List<String> inputNames = new ArrayList<>();
//        String name = reader.readLine();
//        while (!"".equalsIgnoreCase(name)) {
//            inputNames.add(name);
//            name = reader.readLine();
//        }
//
//        List<BasicIngredient> ingredients = this.ingredientService.getIngredientsByExactNames(inputNames);
//        this.shampooService.getShampoosByIngredientsName(ingredients).forEach(s -> System.out.println(s.getBrand()));

//        long ingredientsCount = Long.parseLong(reader.readLine());
//        this.shampooService.getShampoosWithIngredientCountsLessThan(ingredientsCount)
//                .forEach(s -> System.out.println(s.getBrand()));

        String shampooName = reader.readLine();
        System.out.println(this.shampooService.getShampooIngredientsTotalPrice(shampooName).toString());
    }
}
