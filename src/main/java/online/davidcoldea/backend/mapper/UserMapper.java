package online.davidcoldea.backend.mapper;

import online.davidcoldea.backend.dto.UserDto;
import online.davidcoldea.backend.entity.MyUser;

public class UserMapper {
    //no need to create an object of this class to use method
    public static MyUser mapToUser(UserDto userDto) {
        MyUser user = new MyUser(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getName(),
                userDto.getEmail()
        );
        return user;
    }

    public static UserDto mapToUserDto(MyUser user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getEmail()
        );
        return userDto;
    }

}
