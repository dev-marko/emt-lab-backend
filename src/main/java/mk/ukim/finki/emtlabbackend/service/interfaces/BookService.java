package mk.ukim.finki.emtlabbackend.service.interfaces;

import mk.ukim.finki.emtlabbackend.domain.dtos.BookDTO;
import mk.ukim.finki.emtlabbackend.domain.entities.Book;
import mk.ukim.finki.emtlabbackend.domain.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    // create
    Book save(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> save(BookDTO bookDTO);

    // update
    Book edit(Long id, String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id, BookDTO bookDTO);

    // read
    List<Book> findAll();

    Optional<Book> findById(Long bookId);

    // delete
    Book deleteById(Long bookId);

    Optional<Book> markAsTaken(Long bookId);

}
