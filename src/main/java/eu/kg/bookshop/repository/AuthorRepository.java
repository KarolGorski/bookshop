package eu.kg.bookshop.repository;

import eu.kg.bookshop.model.Author;
import eu.kg.bookshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findById(long id);
}

