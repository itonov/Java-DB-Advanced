package bookshop_system;

import bookshop_system.entities.Author;
import bookshop_system.entities.Book;
import bookshop_system.entities.Category;
import bookshop_system.enums.AgeRestriction;
import bookshop_system.enums.EditionType;
import bookshop_system.services.AuthorService;
import bookshop_system.services.BookService;
import bookshop_system.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;

    @Autowired
    public ConsoleRunner(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {
//        seedDatabase();
        this.bookService.getAllBooksAfterYear2000().forEach(b -> System.out.println(b.getTitle()));
    }

    private void seedDatabase() throws IOException, ParseException {
        seedAuthorsFromFile();
        seedCategoriesFromFile();
        seedBooksFromFile();
    }

    private void seedCategoriesFromFile() throws IOException {
        Path path = FileSystems
                .getDefault()
                .getPath("D:\\Java-DB-Advanced\\SpringDataIntro\\bookshop_system\\src\\main\\resources\\categories.txt");
        List<String> lines = Files.lines(path).filter(l -> !l.equals("")).collect(Collectors.toList());
        List<Category> categories = lines.stream().map(Category::new).collect(Collectors.toList());
        this.categoryService.addCategoriesToDb(categories);
    }

    private void seedBooksFromFile() throws IOException, ParseException {
        BufferedReader booksReader = new BufferedReader(
                new FileReader("D:\\Java-DB-Advanced\\SpringDataIntro\\bookshop_system\\src\\main\\resources\\books.txt"));
        String line = booksReader.readLine();
        List<Author> authors = this.authorService.getAllAuthors();
        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            Random random = new Random();
            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();
            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType.toString());
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction.toString());
            book.setTitle(title);
            book.getCategories().add(this.categoryService.getAllCategories().get(random.nextInt(
                    this.categoryService.getAllCategories().size()
            )));
            book.getCategories().add(this.categoryService.getAllCategories().get(random.nextInt(
                    this.categoryService.getAllCategories().size()
            )));

            this.bookService.saveBookIntoDb(book);
        }
    }

    private void seedAuthorsFromFile() throws IOException {
        Path path = FileSystems
                .getDefault()
                .getPath("D:\\Java-DB-Advanced\\SpringDataIntro\\bookshop_system\\src\\main\\resources\\authors.txt");
        List<String> lines = Files.lines(path).collect(Collectors.toList());
        List<Author> authors = lines.stream().map(l -> new Author(l.split("\\s+")[0], l.split("\\s+")[1]))
                .collect(Collectors.toList());
        this.authorService.saveAuthorsIntoDb(authors);
    }
}
