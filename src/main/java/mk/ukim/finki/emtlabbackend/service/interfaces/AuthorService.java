package mk.ukim.finki.emtlabbackend.service.interfaces;

import mk.ukim.finki.emtlabbackend.domain.entities.Author;

import java.util.List;

public interface AuthorService {

    // create
    Author save(String name, String surname, Long countryId);

    // update
    Author edit(Long id, String name, String surname, Long countryId);

    // read
    List<Author> findAll();

    Author findById(Long authorId);

    // delete
    Author deleteById(Long authorId);

}
