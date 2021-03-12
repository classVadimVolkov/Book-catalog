package by.volkov.testtask.web;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorService service;

    @Autowired
    public AuthorsController(AuthorService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Author>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> get(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(service.create(author), HttpStatus.CREATED);
    }

    @PutMapping("/id")
    public ResponseEntity<?> update(@RequestBody @Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        service.update(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
