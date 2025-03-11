package edu.kushnirenko.security25.book;

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
public interface BookRepository extends MongoRepository<Book, String> {

}
