package mk.ukim.finki.emtlabbackend.domain.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emtlabbackend.domain.enumerations.Category;

@Data
@NoArgsConstructor
public class BookDTO {

    private String name;
    private Category category;
    private Long authorId;
    private Integer availableCopies;

    public BookDTO(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}
