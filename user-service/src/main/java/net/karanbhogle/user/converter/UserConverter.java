package net.karanbhogle.user.converter;

import org.springframework.stereotype.Component;

import net.karanbhogle.user.dto.UserDTO;
import net.karanbhogle.user.entity.User;

@Component
public class UserConverter {

    public static UserDTO convertUserEntitytoDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getPassword());
    }

    public static User convertUserDTOtoEntity(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getEmail(), userDTO.getPassword());
    }
}
