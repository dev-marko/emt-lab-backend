package mk.ukim.finki.emtlabbackend.service.implementations;

import mk.ukim.finki.emtlabbackend.domain.entities.Author;
import mk.ukim.finki.emtlabbackend.domain.entities.Book;
import mk.ukim.finki.emtlabbackend.domain.enumerations.Category;
import mk.ukim.finki.emtlabbackend.domain.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emtlabbackend.domain.exceptions.BookNotFoundException;
import mk.ukim.finki.emtlabbackend.repository.AuthorRepository;
import mk.ukim.finki.emtlabbackend.service.interfaces.BookService;
import mk.ukim.finki.emtlabbackend.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        return this.bookRepository.save(new Book(name, category, author, availableCopies));
    }

    @Override
    public Book edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.findById(id);

        book.setName(name);
        book.setCategory(category);
        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long bookId) {
        return this.bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
    }

    @Override
    public Book deleteById(Long bookId) {
        Book book = this.findById(bookId);
        this.bookRepository.delete(book);
        return book;
    }
}
