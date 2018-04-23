package bookshop_system.services;

import bookshop_system.entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    void saveAuthorsIntoDb(List<Author> authors);

    List<Author> getAllAuthors();

}
