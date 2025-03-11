package edu.kushnirenko.security25.item;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Objects;

/*
  @author   Sofiia
  @project   security25
  @class  Item
  @version  1.0.0 
  @since 10.03.2025 - 20.06
*/
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Book {
    @Id
    private String id;
    private String name;
    private String anotation;

    public Book(String name, String description) {
        this.name = name;
        this.anotation = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book item = (Book) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
