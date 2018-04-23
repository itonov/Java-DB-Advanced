package bookshop_system.services;

import bookshop_system.entities.Book;
import bookshop_system.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
}
