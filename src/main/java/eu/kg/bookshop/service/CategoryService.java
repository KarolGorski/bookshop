package eu.kg.bookshop.service;

import eu.kg.bookshop.model.Author;
import eu.kg.bookshop.model.Book;
import eu.kg.bookshop.model.Category;
import eu.kg.bookshop.repository.BookRepository;
import eu.kg.bookshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;
    BookRepository bookRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void saveCategory(String name) {
        Category category = new Category(name);
        categoryRepository.save(category);
    }

    public void updateCategory(long id, String name) {
        Category category = categoryRepository.findById(id);
        category.setName(name);
        categoryRepository.save(category);
    }

    public void deleteCategory(long id) {
        Category category = categoryRepository.findById(id);
        List<Book> books = category.getBooks();
        Category noCategory = categoryRepository.findByName("No category");
        if(noCategory == null) {
            noCategory = new Category("No category");
        }
        for (Book book : books) {
            book.setCategory(noCategory);
        }
        bookRepository.saveAll(category.getBooks());
        categoryRepository.deleteById(id);
    }
}
