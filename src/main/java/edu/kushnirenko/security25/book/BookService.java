package edu.kushnirenko.security25.book;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
  @author   Sofiia
  @project   security25
  @class  ItemService
  @version  1.0.0
  @since 10.03.2025 - 20.11
*/
@Service
@AllArgsConstructor
public class BookService {
    private BookRepository repository;

    private List<Book> books;

    @PostConstruct
    void init() {
        books.add(new Book("1", "It", "description1"));
        books.add(new Book("2", "Peter Pan", "description2"));
        books.add(new Book("3", "Novel", "description3"));
        repository.saveAll(books);
    }

    public List<Book> getAll() {
        return repository.findAll();
    }

    public Book getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Book create(Book item) {
        return repository.save(item);
    }

    public Book update(Book item) {
        return repository.save(item);
    }
}
