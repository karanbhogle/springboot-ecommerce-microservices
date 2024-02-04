package net.karanbhogle.user.service;

import java.util.List;

import net.karanbhogle.user.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO login(UserDTO userDTO);

	List<UserDTO> getAllUsers();

}