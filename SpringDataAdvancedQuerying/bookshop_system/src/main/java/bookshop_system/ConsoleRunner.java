package bookshop_system;

import bookshop_system.dto.ReducedBook;
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
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        seedDatabase();
//        this.bookService.getAllBooksAfterYear2000().forEach(b -> System.out.println(b.getTitle()));
//        printBooksTitleWithAgeRestriction(reader.readLine());
//        bookTitlesByEditionAndCopies(reader.readLine());
//        booksByPriceBetween(reader.readLine());
//        booksByExcludedReleaseYear(reader.readLine());
//        booksReleasedBefore(reader.readLine());
//        authorsByFirstNameEnding(reader.readLine());
//        bookTitlesContaining(reader.readLine());
//        booksByAuthorLastNameStarting(reader.readLine());
//        booksCountByTitleLongerThan(Integer.parseInt(reader.readLine()));
//        totalCopiesPerAuthor();
        reducedBookByTitle(reader.readLine());
    }

    private void reducedBookByTitle(String title) {
        ReducedBook result = this.bookService.reducedBookByTitle(title);
        System.out.printf("%s %s %s %.2f%n",
                result.getTitle(),
                result.getEditionType().toUpperCase(),
                result.getAgeRestriction().toUpperCase(),
                result.getPrice());
    }

    private void totalCopiesPerAuthor() {
        this.authorService.totalCopiesPerAuthor().forEach(o -> System.out.println(o[0] + " - " + o[1]));
    }

    private void booksCountByTitleLongerThan(int inputNum) {
        System.out.println(this.bookService.countOfBooksWithTitleLongerThan(inputNum));
    }

    private void booksByAuthorLastNameStarting(String input) {
        this.bookService.booksByAuthorLastNameStarting(input)
                .forEach(b -> System.out.println(b.getTitle() + " (" +
                        b.getAuthor().getFirstName() + " " + b.getAuthor().getLastName() + ")"));
    }

    private void bookTitlesContaining(String input) {
        this.bookService.titlesContaining(input).forEach(System.out::println);
    }

    private void authorsByFirstNameEnding(String end) {
        this.authorService.authorsByNameEnding(end)
                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    private void booksReleasedBefore(String inputDate) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = df.parse(inputDate);
        this.bookService.booksReleasedBefore(date).forEach(b -> System.out.println(b.getTitle()));
    }

    private void booksByExcludedReleaseYear(String inputYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(inputYear));
        Date neededDate = calendar.getTime();
        this.bookService.booksByExcludedReleaseDate(neededDate).forEach(b -> System.out.println(b.getTitle()));
    }

    private void booksByPriceBetween(String input) {
        this.bookService.booksByPriceLowerAndHigherThan(new BigDecimal(input.split(" ")[0]), new BigDecimal(input.split(" ")[1]))
                .forEach(b -> System.out.println(b.getTitle() + " - " + b.getPrice().toString()));
    }

    private void bookTitlesByEditionAndCopies(String input) {
        String[] tokens = input.split(" ");
        this.bookService.titlesByEditionTypeAndCopies(tokens[0].toUpperCase(), Integer.parseInt(tokens[1]))
                .forEach(System.out::println);
    }

    private void printBooksTitleWithAgeRestriction(String restriction) {
        this.bookService.booksByAgeRestriction(restriction)
                .forEach(b -> System.out.println(b.getTitle()));
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
