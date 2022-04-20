package mk.ukim.finki.emtlabbackend.service.implementations;

import mk.ukim.finki.emtlabbackend.domain.dtos.BookDTO;
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
import java.util.Optional;

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
    public Optional<Book> save(BookDTO bookDTO) {
        Author author = this.authorRepository.findById(bookDTO.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDTO.getAuthorId()));
        Book book = new Book(bookDTO.getName(), bookDTO.getCategory(), author, bookDTO.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Book edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(name);
        book.setCategory(category);
        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        return this.bookRepository.save(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDTO bookDTO) {
        Book book = this.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDTO.getName());
        book.setCategory(bookDTO.getCategory());
        Author author = this.authorRepository.findById(bookDTO.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDTO.getAuthorId()));
        book.setAuthor(author);
        book.setAvailableCopies(bookDTO.getAvailableCopies());

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return this.bookRepository.findById(bookId);
    }

    @Override
    public Book deleteById(Long bookId) {
        Book book = this.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        this.bookRepository.delete(book);
        return book;
    }
}
