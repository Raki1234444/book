package BookHeaven.Book.repository;


import BookHeaven.Book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
