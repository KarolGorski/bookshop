package eu.kg.bookshop.service;

import eu.kg.bookshop.model.Author;
import eu.kg.bookshop.model.Book;
import eu.kg.bookshop.model.Category;
import eu.kg.bookshop.repository.AuthorRepository;
import eu.kg.bookshop.repository.BookRepository;
import eu.kg.bookshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookRepository bookRepository;
    AuthorRepository authorRepository;
    CategoryRepository categoryRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository,
                       CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(String name, String publisher, float cost, String categoryName, String authorName) {
        Category category = categoryRepository.findByName(categoryName);
        if(category == null) {
            category = new Category(categoryName);
            categoryRepository.save(category);
        }
        Author author = authorRepository.findByName(authorName);
        if(author == null) {
            author = new Author(authorName);
            authorRepository.save(author);
        }
        Book book = new Book(name, publisher, cost, category);
        book.addAuthor(author);
        bookRepository.save(book);
    }

    public void updateBook(long id, String name, String publisher, float cost, String categoryName, String authorName) {
        Book book = bookRepository.findById(id);
        book.setName(name);
        book.setPublisher(publisher);
        book.setCost(cost);
        Category category = categoryRepository.findByName(categoryName);
        if(category == null) {
            category = new Category(categoryName);
            categoryRepository.save(category);
        }
        Author author = authorRepository.findByName(authorName);
        if(author == null) {
            author = new Author(authorName);
            authorRepository.save(author);
        }
        book.setCategory(category);
        book.addAuthor(author);
        bookRepository.save(book);
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}
