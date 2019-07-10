package eu.kg.bookshop.controller;

import eu.kg.bookshop.model.Category;
import eu.kg.bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String getCategories(Model model) {
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "categorieslist";
    }

    @PostMapping("")
    public String saveCategory(HttpServletRequest request) {
        categoryService.saveCategory(request.getParameter("name"));
        return "redirect:/category";
    }

    @PostMapping("/put")
    public String putCategory(HttpServletRequest request) {
        categoryService.updateCategory(Long.parseLong(request.getParameter("id")),
                request.getParameter("name"));
        return "redirect:/category";
    }

    @PostMapping("/delete")
    public String deleteCategory(HttpServletRequest request) {
        categoryService.deleteCategory(Long.parseLong(request.getParameter("id")));
        return "redirect:/category";
    }
}
