package eu.kg.bookshop.controller;

import eu.kg.bookshop.model.Author;
import eu.kg.bookshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public String getAuthors(Model model) {
        List<Author> authors = authorService.getAuthors();
        model.addAttribute("authors", authors);
        return "authorslist";
    }

    @PostMapping("")
    public String saveAuthor(HttpServletRequest request) {
        authorService.saveAuthor(request.getParameter("name"));
        return "redirect:/author";
    }

    @PostMapping("/put")
    public String putAuthor(HttpServletRequest request) {
        authorService.updateAuthor(Long.parseLong(request.getParameter("id")), request.getParameter("name"));
        return "redirect:/author";
    }

    @PostMapping("/delete")
    public String deleteAuthor(HttpServletRequest request) {
        authorService.deleteAuthor(Long.parseLong(request.getParameter("id")));
        return "redirect:/author";
    }
}
