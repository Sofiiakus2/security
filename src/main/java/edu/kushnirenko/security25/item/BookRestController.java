package edu.kushnirenko.security25.item;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author   Sofiia
  @project   security25
  @class  ItemRestController
  @version  1.0.0 
  @since 10.03.2025 - 20.12
*/
@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookRestController {
    private BookService service;

    @GetMapping
    public List<Book> getItems() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book getOneItem(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }

    @PostMapping
    public Book create(@RequestBody Book item) {
        return  service.create(item);
    }

    @PutMapping
    public Book update(@RequestBody Book item) {
        return service.update(item);
    }

    @GetMapping("/user")
    public String helloUser(){
        return "Hello User";
    }

    @GetMapping("/admin")
    public String helloAdmin(){
        return "Hello Admin";
    }

    @GetMapping("/unknown")
    public String helloUnknown(){
        return "Hello Unknown";
    }


}
