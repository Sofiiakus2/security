package edu.kushnirenko.security25.item;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
  @author   Sofiia
  @project   security25
  @class  ItemRepository
  @version  1.0.0 
  @since 10.03.2025 - 20.10
*/
@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

}
