package eu.kg.bookshop.service;

import eu.kg.bookshop.model.Author;
import eu.kg.bookshop.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    AuthorRepository authorRepository;

    @Autowired
    AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void saveAuthor(String name) {
        Author author = new Author(name);
        authorRepository.save(author);
    }

    public void updateAuthor(long id, String name) {
        Author author = authorRepository.findById(id);
        author.setName(name);
        authorRepository.save(author);
    }

    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }
}
