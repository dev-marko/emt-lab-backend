package mk.ukim.finki.emtlabbackend.web.controllers;

import mk.ukim.finki.emtlabbackend.domain.entities.Country;
import mk.ukim.finki.emtlabbackend.service.interfaces.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
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
