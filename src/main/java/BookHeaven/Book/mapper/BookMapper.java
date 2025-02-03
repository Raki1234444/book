package BookHeaven.Book.mapper;

import BookHeaven.Book.dto.BookDto;
import BookHeaven.Book.model.Book;
import org.springframework.stereotype.Component;

@Component // Makes it a Spring-managed bean
public class BookMapper {

    // Convert Book entity to BookDTO
    public BookDto toDTO(Book book) {
        BookDto bookDTO = new BookDto();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setStock(book.getStock());
        bookDTO.setImageUrl(book.getImageUrl());
        return bookDTO;
    }

    // Convert BookDTO to Book entity
    public Book toEntity(BookDto bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(bookDTO.getCategory());
        book.setPrice(bookDTO.getPrice());
        book.setStock(bookDTO.getStock());
        book.setImageUrl(bookDTO.getImageUrl());
        return book;
    }
}