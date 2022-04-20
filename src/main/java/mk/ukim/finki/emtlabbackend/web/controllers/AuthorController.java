package mk.ukim.finki.emtlabbackend.web.controllers;

import mk.ukim.finki.emtlabbackend.domain.entities.Author;
import mk.ukim.finki.emtlabbackend.service.interfaces.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// Tekstot na vezbata ne specificirase dali treba da napravime Add, Edit, Delete funkcionalnost na front-end
// za avtor taka sto samo prikazuvanje imam na vekje postoecki avtori vo bazata.

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public List<Author> findAll() {
        return this.authorService.findAll();
    }
}
