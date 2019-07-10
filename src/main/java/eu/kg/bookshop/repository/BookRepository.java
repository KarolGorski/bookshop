package eu.kg.bookshop.repository;

import eu.kg.bookshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);
}
