package bookshop_system.repositories;

import bookshop_system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByReleaseDateAfter(Date date);

    List<Book> findAllByAgeRestrictionIsAfter(String restriction);

    @Query(value = "SELECT b.title FROM Book AS b WHERE b.editionType LIKE :edition AND b.copies < :copies")
    List<String> getTitlesByhEditionTypeAndCopies(@Param(value = "edition") String edition,
                                                              @Param(value = "copies") int copies);

    List<Book> getBooksByPriceBeforeOrPriceAfter(BigDecimal low, BigDecimal high);

    List<Book> getBooksByReleaseDateIsNot(Date date);

    List<Book> getBooksByReleaseDateBefore(Date date);

    @Query(value = "SELECT b.title FROM Book AS b WHERE LOWER(b.title) LIKE CONCAT('%', :titlePart, '%')")
    List<String> titlesContaining(@Param("titlePart") String part);

    @Query(value = "SELECT b FROM Book AS b WHERE LOWER(b.author.lastName) LIKE CONCAT(:lastName, '%')")
    List<Book> titlesByAuthorLastNameStarting(@Param("lastName") String lastNameStart);

    @Query(value = "SELECT COUNT(b) FROM Book AS b WHERE LENGTH(b.title) > :num")
    int countByTitleLongerThan(@Param(value = "num") int num);

    Book findByTitle(String title);
}
