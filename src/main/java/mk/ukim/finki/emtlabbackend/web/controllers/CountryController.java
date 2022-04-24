package mk.ukim.finki.emtlabbackend.web.controllers;

import mk.ukim.finki.emtlabbackend.domain.entities.Country;
import mk.ukim.finki.emtlabbackend.service.interfaces.CountryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// Tekstot na vezbata ne specificirase dali treba da napravime Add, Edit, Delete funkcionalnost na front-end
// za drzava taka sto samo prikazuvanje imam na vekje postoecki drzavi vo bazata.

@RestController
@CrossOrigin(origins = "https://emt-lab-191128-frontend.herokuapp.com/")
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping()
    public List<Country> findAll() {
        return this.countryService.findAll();
    }
}
