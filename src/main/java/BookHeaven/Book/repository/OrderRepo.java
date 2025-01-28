package BookHeaven.Book.repository;

import BookHeaven.Book.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
