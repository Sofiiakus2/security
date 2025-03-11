package edu.kushnirenko.security25.item;

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
public class ItemService {
    private ItemRepository repository;

    private List<Item> items;

    @PostConstruct
    void init() {
        items.add(new Item("1", "name1", "description1"));
        items.add(new Item("2", "name2", "description2"));
        items.add(new Item("3", "name3", "description3"));
        repository.saveAll(items);
    }

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Item getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Item create(Item item) {
        return repository.save(item);
    }

    public Item update(Item item) {
        return repository.save(item);
    }
}
