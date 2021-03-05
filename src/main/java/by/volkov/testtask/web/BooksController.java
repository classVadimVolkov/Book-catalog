package by.volkov.testtask.web;

import by.volkov.testtask.model.Book;
import by.volkov.testtask.model.SexType;
import by.volkov.testtask.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService service;

    @Autowired
    public BooksController(BookService service) {
        this.service = service;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("books", service.getAll());
        return "books/catalog";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", service.get(id));
        return "books/get";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }

        service.create(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", service.get(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }

        service.update(book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/books";
    }

    @GetMapping()
    public String getAllByTitle(@RequestParam("title") String title, Model model) {
        model.addAttribute("booksByTitle", service.getAllByTitle(title));
        return "books/catalog";
    }

    @GetMapping()
    public String getAllByPublicationYear(@RequestParam("publicationYear") LocalDate publicationYear, Model model) {
        model.addAttribute("booksByPublicationYear", service.getAllByPublicationYear(publicationYear));
        return "books/catalog";
    }

    @GetMapping()
    public String getAllByPublishingHouse(@RequestParam("publishingHouse") String publishingHouse, Model model) {
        model.addAttribute("booksByPublishingHouse", service.getAllByPublishingHouse(publishingHouse));
        return "books/catalog";
    }

    @GetMapping()
    public String getAllByAuthorFirstLettersNameOrSurname(@RequestParam("authorName") String name,
                                                          @RequestParam("authorSurname") String surname, Model model) {

        model.addAttribute("booksByAuthorFirstLettersNameOrSurname",
                service.getAllByAuthorFirstLettersNameOrSurname(name, surname));
        return "books/catalog";
    }

    @GetMapping()
    public String getAllByAuthorSex(@RequestParam("authorSex") SexType sex, Model model) {
        model.addAttribute("booksByAuthorSex", service.getAllByAuthorSex(sex));
        return "books/catalog";
    }

    @GetMapping()
    public String getAllByAuthorBirthday(@RequestParam("authorBirthday") LocalDate birthday, Model model) {
        model.addAttribute("booksByAuthorBirthday", service.getAllByAuthorBirthday(birthday));
        return "books/catalog";
    }

    @GetMapping()
    public String getAllFiltered(@RequestParam("title") String title,
                                 @RequestParam("publicationYear") LocalDate publicationYear,
                                 @RequestParam("publishingHouse") String publishingHouse,
                                 @RequestParam("authorName") String authorName,
                                 @RequestParam("authorSurname") String authorSurname,
                                 @RequestParam("authorSex") SexType authorSex,
                                 @RequestParam("authorBirthday") LocalDate authorBirthday,
                                 Model model) {

        model.addAttribute("booksByFilters", service.getAllFiltered(title, publicationYear, publishingHouse,
                authorName, authorSurname, authorSex, authorBirthday));
        return "books/catalog";
    }
}
