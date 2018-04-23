package bookshop_system.repositories;

import bookshop_system.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> getAllByFirstNameEndsWith(String end);

    @Query(value = "SELECT CONCAT(a.firstName, ' ', a.lastName) AS name, SUM(b.copies) AS sumc FROM Author AS a JOIN Book AS b " +
            " ON a.id = b.author.id GROUP BY CONCAT(a.firstName, ' ', a.lastName) ORDER BY SUM(b.copies) DESC ")
    List<Object[]> totalCopiesPerAuthor();
}
