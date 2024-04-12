package online.davidcoldea.backend.service;

import online.davidcoldea.backend.dto.UserDto;
import online.davidcoldea.backend.entity.MyUser;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    void deleteUserById(Long id);

    UserDto updateUser(Long id , UserDto updatedUserDto);

    UserDto findMyUserByEmail(String email);
}
