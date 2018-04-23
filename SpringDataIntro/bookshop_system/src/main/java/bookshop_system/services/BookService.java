package bookshop_system.services;

import bookshop_system.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    void saveBookIntoDb(Book book);

    List<Book> getAllBooksAfterYear2000();
}
