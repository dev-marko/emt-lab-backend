package mk.ukim.finki.emtlabbackend.service.implementations;

import mk.ukim.finki.emtlabbackend.domain.entities.Author;
import mk.ukim.finki.emtlabbackend.domain.entities.Country;
import mk.ukim.finki.emtlabbackend.domain.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emtlabbackend.domain.exceptions.CountryNotFoundException;
import mk.ukim.finki.emtlabbackend.repository.AuthorRepository;
import mk.ukim.finki.emtlabbackend.repository.CountryRepository;
import mk.ukim.finki.emtlabbackend.service.interfaces.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Author save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException(countryId));
        return this.authorRepository.save(new Author(name, surname, country));
    }

    @Override
    public Author edit(Long id, String name, String surname, Long countryId) {
        Author author = this.findById(id);

        author.setName(name);
        author.setSurname(surname);
        Country country = this.countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException(countryId));
        author.setCountry(country);

        return this.authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(Long authorId) {
        return this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
    }

    @Override
    public Author deleteById(Long authorId) {
        Author author = this.findById(authorId);
        this.authorRepository.delete(author);
        return author;
    }
}
