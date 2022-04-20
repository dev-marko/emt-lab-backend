package mk.ukim.finki.emtlabbackend.web.controllers;

import mk.ukim.finki.emtlabbackend.domain.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Tekstot na vezbata ne specificirase dali treba da napravime Add, Edit, Delete funkcionalnost na front-end
// za kategorija taka sto samo prikazuvanje imam na vekje postoecki kategorii vo bazata.

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryController {

    // /categories na front-end ke go povika ovoj metod
    @GetMapping()
    public List<Category> findAll() {
        return Arrays.stream(Category.values()).collect(Collectors.toList());
    }

}
