package bookshop_system.services;

import bookshop_system.dto.ReducedBook;
import bookshop_system.entities.Book;
import bookshop_system.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBookIntoDb(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooksAfterYear2000() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, 2000);
        Date date = calendar.getTime();
        return this.bookRepository.findAllByReleaseDateAfter(date);
    }

    @Override
    public List<Book> booksByAgeRestriction(String restriction) {
        return this.bookRepository.findAllByAgeRestrictionIsAfter(restriction);
    }

    @Override
    public List<String> titlesByEditionTypeAndCopies(String edition, int copies) {
        return this.bookRepository.getTitlesByhEditionTypeAndCopies(edition, copies);
    }

    @Override
    public List<Book> booksByPriceLowerAndHigherThan(BigDecimal low, BigDecimal high) {
        return this.bookRepository.getBooksByPriceBeforeOrPriceAfter(low, high);
    }

    @Override
    public List<Book> booksByExcludedReleaseDate(Date date) {
        return this.bookRepository.getBooksByReleaseDateIsNot(date);
    }

    @Override
    public List<Book> booksReleasedBefore(Date date) {
        return this.bookRepository.getBooksByReleaseDateBefore(date);
    }

    @Override
    public List<String> titlesContaining(String words) {
        return this.bookRepository.titlesContaining(words.toLowerCase());
    }

    @Override
    public List<Book> booksByAuthorLastNameStarting(String start) {
        return this.bookRepository.titlesByAuthorLastNameStarting(start.toLowerCase());
    }

    @Override
    public int countOfBooksWithTitleLongerThan(int num) {
        return this.bookRepository.countByTitleLongerThan(num);
    }

    @Override
    public ReducedBook reducedBookByTitle(String title) {
        Book result = this.bookRepository.findByTitle(title);
        return new ReducedBook(result.getTitle(), result.getEditionType(), result.getAgeRestriction(), result.getPrice());
    }
}
