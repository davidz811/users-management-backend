package online.davidcoldea.backend.service.impl;

import online.davidcoldea.backend.dto.UserDto;
import online.davidcoldea.backend.entity.MyUser;
import online.davidcoldea.backend.exception.UserNotFoundException;
import online.davidcoldea.backend.mapper.UserMapper;
import online.davidcoldea.backend.repository.UserRepository;
import online.davidcoldea.backend.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        MyUser user = UserMapper.mapToUser(userDto);
        MyUser createUser = userRepository.save(user);
        UserDto userDto1 = UserMapper.mapToUserDto(createUser);
        return userDto1;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<MyUser> userList = userRepository.findAll();
        List<UserDto> userDtoList = userList.stream().map(UserMapper::mapToUserDto).toList();
        return userDtoList;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<MyUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            MyUser user1 = user.get();
            UserDto userDto = UserMapper.mapToUserDto(user1);
            return userDto;
        }   else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<MyUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public UserDto updateUser(Long id , UserDto updatedUserDto) {
        Optional<MyUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            MyUser existingUser = user.get();
            existingUser.setName(updatedUserDto.getName());
            existingUser.setUsername(updatedUserDto.getUsername());
            existingUser.setEmail(updatedUserDto.getEmail());

            //save the updated user
            MyUser savedUser = userRepository.save(existingUser);

            UserDto userDto = UserMapper.mapToUserDto(savedUser);
            return userDto;
        }   else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public UserDto findMyUserByEmail(String email) {
        Optional<MyUser> user = userRepository.findMyUserByEmail(email);
        if (user.isPresent()) {
            MyUser getUser = user.get();
            UserDto userDto = UserMapper.mapToUserDto(getUser);
            return userDto;
        }   else {
            return null;
        }
    }
}
