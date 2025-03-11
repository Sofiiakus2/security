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
@RequestMapping("/api/v1/items")
@AllArgsConstructor
public class ItemRestController {
    private ItemService service;

    @GetMapping
    public List<Item> getItems() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Item getOneItem(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return  service.create(item);
    }

    @PutMapping
    public Item update(@RequestBody Item item) {
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
