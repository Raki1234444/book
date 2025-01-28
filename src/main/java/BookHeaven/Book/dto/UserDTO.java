package BookHeaven.Book.dto;

import BookHeaven.Book.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private Long id;
    private  String username;
    private  String  password;
    private String email;
    private String name;
    private String contactNumber;
    private String role;
    private Boolean active;
    private List<Order> orders;
}
