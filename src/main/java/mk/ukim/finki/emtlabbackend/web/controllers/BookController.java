package mk.ukim.finki.emtlabbackend.web.controllers;

import mk.ukim.finki.emtlabbackend.domain.dtos.BookDTO;
import mk.ukim.finki.emtlabbackend.domain.entities.Book;
import mk.ukim.finki.emtlabbackend.service.interfaces.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Na front-end ke imam / ili /books za da se povika do /api/books
    @GetMapping()
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody BookDTO bookDTO) {
        return this.bookService.save(bookDTO)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return this.bookService.edit(id, bookDTO)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        Book book = this.bookService.deleteById(id);

        if (this.bookService.findById(id).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(book);
    }
}
