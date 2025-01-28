package BookHeaven.Book.mapper;


import BookHeaven.Book.dto.UserDTO;
import BookHeaven.Book.model.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .contactNumber(user.getContactNumber())
                .role(user.getRole())
                .active(user.getActive())
                .orders(user.getOrders())
                .build();
    }
    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return User.builder()
                .id(userDTO.getId())
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .contactNumber(userDTO.getContactNumber())
                .role(userDTO.getRole())
                .active(userDTO.getActive())
                .orders(userDTO.getOrders())
                .build();
    }
}

