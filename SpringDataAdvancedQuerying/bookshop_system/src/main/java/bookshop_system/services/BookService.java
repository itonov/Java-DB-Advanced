package bookshop_system.services;

import bookshop_system.dto.ReducedBook;
import bookshop_system.entities.Book;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public interface BookService {
    void saveBookIntoDb(Book book);

    List<Book> getAllBooksAfterYear2000();

    List<Book> booksByAgeRestriction(String restriction);

    List<String> titlesByEditionTypeAndCopies(String edition, int copies);

    List<Book> booksByPriceLowerAndHigherThan(BigDecimal low, BigDecimal high);

    List<Book> booksByExcludedReleaseDate(Date date);

    List<Book> booksReleasedBefore(Date date);

    List<String> titlesContaining(String words);

    List<Book> booksByAuthorLastNameStarting(String start);

    int countOfBooksWithTitleLongerThan(int num);

    ReducedBook reducedBookByTitle(String title);
}
