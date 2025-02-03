package BookHeaven.Book.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String name;
    private String author;
    private String category;
    private Double price;
    private Integer stock;
    private String imageUrl;
}
