package mk.ukim.finki.emtlabbackend.service.interfaces;

import mk.ukim.finki.emtlabbackend.domain.entities.Country;

import java.util.List;

public interface CountryService {
    // create
    Country save(String name, String continent);

    // update
    Country edit(Long id, String name, String continent);

    // read
    List<Country> findAll();

    Country findById(Long countryId);

    // delete
    Country deleteById(Long countryId);
}
