package BookHeaven.Book.controller;

import BookHeaven.Book.dto.BookDto;
import BookHeaven.Book.exception.BookNotFoundException;
import BookHeaven.Book.exception.InvalidRequestException;
import BookHeaven.Book.mapper.BookMapper;
import BookHeaven.Book.model.Book;
import BookHeaven.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    // Add a new book
    @PostMapping
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDTO) {
        if (bookDTO == null || bookDTO.getName() == null || bookDTO.getAuthor() == null) {
            throw new InvalidRequestException("Book details are incomplete.");
        }

        Book book = bookMapper.toEntity(bookDTO);
        Book savedBook = bookService.saveBook(book);
        BookDto savedBookDTO = bookMapper.toDTO(savedBook);
        return new ResponseEntity<>(savedBookDTO, HttpStatus.CREATED);
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found.");
        }

        List<BookDto> bookDTOs = books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }

    // Get books by author
    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookDto>> getBooksByAuthor(@PathVariable String author) {
        List<Book> books = bookService.getBooksByAuthor(author);
        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found for author: " + author);
        }

        List<BookDto> bookDTOs = books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }

    // Get books by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<BookDto>> getBooksByCategory(@PathVariable String category) {
        List<Book> books = bookService.getBooksByCategory(category);
        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found in category: " + category);
        }

        List<BookDto> bookDTOs = books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }

    // Search books dynamically
    @GetMapping("/search")
    public ResponseEntity<List<BookDto>> searchBooks(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category) {

        List<Book> books = bookService.searchBooks(name, author, category);
        if (books.isEmpty()) {
            throw new BookNotFoundException("No books matched the search criteria.");
        }

        List<BookDto> bookDTOs = books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }
}
