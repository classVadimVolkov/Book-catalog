package by.volkov.testtask.web;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorService service;

    @Autowired
    public AuthorsController(AuthorService service) {
        this.service = service;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("authors", service.getAll());
        return "authors/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("author", service.get(id));
        return "authors/show";
    }

    @GetMapping("/new")
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "authors/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("author") @Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "authors/new";
        }

        service.create(author);
        return "redirect:/authors";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("author", service.get(id));
        return "authors/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "authors/edit";
        }

        service.update(author);
        return "redirect:/authors";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/authors";
    }
}
