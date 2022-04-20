package mk.ukim.finki.emtlabbackend.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emtlabbackend.domain.enumerations.Category;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @OneToOne
    private Author author;

    private Integer availableCopies;

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
