package mk.ukim.finki.emtlabbackend.service.interfaces;

import mk.ukim.finki.emtlabbackend.domain.entities.Book;
import mk.ukim.finki.emtlabbackend.domain.enumerations.Category;

import java.util.List;

public interface BookService {

    // create
    Book save(String name, Category category, Long authorId, Integer availableCopies);

    // update
    Book edit(Long id, String name, Category category, Long authorId, Integer availableCopies);

    // read
    List<Book> findAll();

    Book findById(Long bookId);

    // delete
    Book deleteById(Long bookId);

}
