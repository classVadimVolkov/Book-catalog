package by.volkov.testtask.web;

import by.volkov.testtask.model.Book;
import by.volkov.testtask.model.SexType;
import by.volkov.testtask.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController()
public class BooksController {

    private final BookService service;

    @Autowired
    public BooksController(BookService service) {
        this.service = service;
    }

/*    @GetMapping("/books")
    public String getAll(Model model) {
        model.addAttribute("books", service.getAll());
        return "books/catalog";
    }

    @GetMapping("/authors/author-id/books/{book-id}")
    public String get(@PathVariable("book-id") int id, Model model) {
        model.addAttribute("book", service.get(id));
        return "books/get";
    }

    @GetMapping("/authors/author-id/books/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping("/authors/{author-id}/books")
    public String create(@PathVariable("author-id") int id,
                         @ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }

        service.create(book, id);
        return "redirect:/books";
    }

    @GetMapping("/authors/author-id/books/{book-id}/edit")
    public String edit(@PathVariable("book-id") int id, Model model) {
        model.addAttribute("book", service.get(id));
        return "books/edit";
    }

    @PatchMapping("/authors/{author-id}/books/book-id")
    public String update(@ModelAttribute("author-id") int id, @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }

        service.update(book, id);
        return "redirect:/books";
    }

    @DeleteMapping("/authors/author-id/books/{book-id}")
    public String delete(@PathVariable("book-id") int id) {
        service.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getAllByTitle(@RequestParam(value = "title", required = false) String title, Model model) {
        model.addAttribute("booksByTitle", service.getAllByTitle(title));
        return "books/catalog";
    }

    @GetMapping("/books")
    public String getAllByPublicationYear(@RequestParam(value = "publicationYear", required = false)
                                                  LocalDate publicationYear, Model model) {
        model.addAttribute("booksByPublicationYear", service.getAllByPublicationYear(publicationYear));
        return "books/catalog";
    }

    @GetMapping("/books")
    public String getAllByPublishingHouse(@RequestParam(value = "publishingHouse", required = false)
                                                  String publishingHouse, Model model) {
        model.addAttribute("booksByPublishingHouse", service.getAllByPublishingHouse(publishingHouse));
        return "books/catalog";
    }

    @GetMapping("/books")
    public String getAllByAuthorFirstLettersNameOrSurname(@RequestParam(value = "authorName", required = false)
                                                                  String name,
                                                          @RequestParam(value = "authorSurname", required = false)
                                                                  String surname, Model model) {

        model.addAttribute("booksByAuthorFirstLettersNameOrSurname",
                service.getAllByAuthorFirstLettersNameOrSurname(name, surname));
        return "books/catalog";
    }

    @GetMapping("/books")
    public String getAllByAuthorSex(@RequestParam(value = "authorSex", required = false) SexType sex, Model model) {
        model.addAttribute("booksByAuthorSex", service.getAllByAuthorSex(sex));
        return "books/catalog";
    }

    @GetMapping("/books")
    public String getAllByAuthorBirthday(@RequestParam(value = "authorBirthday", required = false)
                                                 LocalDate birthday, Model model) {
        model.addAttribute("booksByAuthorBirthday", service.getAllByAuthorBirthday(birthday));
        return "books/catalog";
    }

    @GetMapping("/books")
    public String getAllFiltered(@RequestParam(value = "title", required = false) String title,
                                 @RequestParam(value = "publicationYear", required = false) LocalDate publicationYear,
                                 @RequestParam(value = "publishingHouse", required = false) String publishingHouse,
                                 @RequestParam(value = "authorName", required = false) String authorName,
                                 @RequestParam(value = "authorSurname", required = false) String authorSurname,
                                 @RequestParam(value = "authorSex", required = false) SexType authorSex,
                                 @RequestParam(value = "authorBirthday", required = false) LocalDate authorBirthday,
                                 Model model) {

        model.addAttribute("booksByFilters", service.getAllFiltered(title, publicationYear, publishingHouse,
                authorName, authorSurname, authorSex, authorBirthday));
        return "books/catalog";
    }*/
}
