package eu.kg.bookshop.controller;

import eu.kg.bookshop.model.Book;
import eu.kg.bookshop.repository.BookRepository;
import eu.kg.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String getBooks(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "bookslist";
    }

    @PostMapping("")
    public String saveBook(HttpServletRequest request) {
        bookService.saveBook(request.getParameter("name"),
                request.getParameter("publisher"),
                Float.parseFloat(request.getParameter("cost")),
                request.getParameter("categoryName"),
                request.getParameter("authorName"));
        return "redirect:/book";
    }

    @PostMapping("/put")
    public String putBook(HttpServletRequest request) {
        bookService.updateBook(Long.parseLong(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("publisher"),
                Float.parseFloat(request.getParameter("cost")),
                request.getParameter("categoryName"),
                request.getParameter("authorName"));
        return "redirect:/book";
    }

    @PostMapping("/delete")
    public String deleteBook(HttpServletRequest request) {
        bookService.deleteBook(Long.parseLong(request.getParameter("id")));
        return "redirect:/book";
    }
}

