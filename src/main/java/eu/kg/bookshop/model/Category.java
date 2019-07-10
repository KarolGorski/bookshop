package eu.kg.bookshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.DETACH})
    List<Book> books;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToBookList(Book book) {
        if(books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
    }

    public void removeFromBookList(Book book) {
        books.removeIf(bookFromList -> book.getId() == bookFromList.getId());
    }

    public List<Book> getBooks() {
        return books;
    }
}
