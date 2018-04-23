package bookshop_system.services;

import bookshop_system.entities.Author;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface AuthorService {
    void saveAuthorsIntoDb(List<Author> authors);

    List<Author> getAllAuthors();

    List<Author> authorsByNameEnding(String end);

    List<Object[]> totalCopiesPerAuthor();

}
