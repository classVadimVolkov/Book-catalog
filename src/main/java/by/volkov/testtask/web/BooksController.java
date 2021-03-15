package by.volkov.testtask.web;

import by.volkov.testtask.model.Book;
import by.volkov.testtask.model.SexType;
import by.volkov.testtask.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
public class BooksController {

    private final BookService service;

    @Autowired
    public BooksController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PostMapping("/authors/{author-id}/books")
    public ResponseEntity<?> create(@PathVariable("author-id") int authorId,
                                    @RequestBody @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(service.create(book, authorId), HttpStatus.CREATED);
    }

    @PutMapping("/authors/{author-id}/books/book-id")
    public ResponseEntity<?> update(@PathVariable("author-id") int authorId,
                                    @RequestBody @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.update(book, authorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/authors/author-id/books/{book-id}")
    public ResponseEntity<?> delete(@PathVariable("book-id") int bookId) {
        service.delete(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/books/getAllByTitle")
    public ResponseEntity<List<Book>> getAllByTitle(@RequestParam(value = "title", required = false)
                                                            String title) {
        return new ResponseEntity<>(service.getAllByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/books/getAllByPublicationYear")
    public ResponseEntity<List<Book>> getAllByPublicationYear(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "publicationYear", required = false)
                    LocalDate publicationYear) {
        return new ResponseEntity<>(service.getAllByPublicationYear(publicationYear), HttpStatus.OK);
    }

    @GetMapping("/books/getAllByPublishingHouse")
    public ResponseEntity<List<Book>> getAllByPublishingHouse(
            @RequestParam(value = "publishingHouse", required = false) String publishingHouse) {
        return new ResponseEntity<>(service.getAllByPublishingHouse(publishingHouse), HttpStatus.OK);
    }

    @GetMapping("/books/getAllByAuthorFirstLettersNameOrSurname")
    public ResponseEntity<List<Book>> getAllByAuthorFirstLettersNameOrSurname(
            @RequestParam(value = "authorName", required = false) String name,
            @RequestParam(value = "authorSurname", required = false) String surname) {
        return new ResponseEntity<>(service.getAllByAuthorFirstLettersNameOrSurname(name, surname),
                HttpStatus.OK);
    }

    @GetMapping("/books/getAllByAuthorSex")
    public ResponseEntity<List<Book>> getAllByAuthorSex(
            @RequestParam(value = "authorSex", required = false) SexType sex) {
        return new ResponseEntity<>(service.getAllByAuthorSex(sex), HttpStatus.OK);
    }

    @GetMapping("/books/getAllByAuthorBirthday")
    public ResponseEntity<List<Book>> getAllByAuthorBirthday(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "authorBirthday", required = false)
                    LocalDate birthday) {
        return new ResponseEntity<>(service.getAllByAuthorBirthday(birthday), HttpStatus.OK);
    }

    @GetMapping("/books/getAllFiltered")
    public ResponseEntity<List<Book>> getAllFiltered(
            @RequestParam(value = "title", required = false) String title,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "publicationYear", required = false)
                    LocalDate publicationYear,
            @RequestParam(value = "publishingHouse", required = false) String publishingHouse,
            @RequestParam(value = "authorName", required = false) String authorName,
            @RequestParam(value = "authorSurname", required = false) String authorSurname,
            @RequestParam(value = "authorSex", required = false) SexType authorSex,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "authorBirthday", required = false)
                    LocalDate authorBirthday) {

        return new ResponseEntity<>(service.getAllFiltered(title, publicationYear, publishingHouse,
                authorName, authorSurname, authorSex, authorBirthday), HttpStatus.OK);
    }
}
