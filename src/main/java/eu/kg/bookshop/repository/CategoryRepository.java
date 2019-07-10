package eu.kg.bookshop.repository;

import eu.kg.bookshop.model.Book;
import eu.kg.bookshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(long id);
}
