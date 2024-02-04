package net.karanbhogle.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.karanbhogle.user.converter.UserConverter;
import net.karanbhogle.user.dto.UserDTO;
import net.karanbhogle.user.entity.User;
import net.karanbhogle.user.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserConverter.convertUserDTOtoEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserConverter.convertUserEntitytoDTO(savedUser);
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        User foundUser = userRepository.findByEmail(userDTO.getEmail());

        if (foundUser == null || !foundUser.getPassword().equals(userDTO.getPassword())) {
            return null;
        }

        UserDTO responseDTO = UserConverter.convertUserEntitytoDTO(foundUser);
        responseDTO.setPassword(null);
        return responseDTO;
    }

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> foundList = userRepository.findAll();
		List<UserDTO> responseList = new ArrayList<>();
		
		for(User foundUser: foundList) {
			UserDTO responseDTO = UserConverter.convertUserEntitytoDTO(foundUser);
	        responseDTO.setPassword(null);
	        responseList.add(responseDTO);
		}
		
		return responseList;
	}

}

