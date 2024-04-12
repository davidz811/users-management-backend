package online.davidcoldea.backend.controller;

import online.davidcoldea.backend.dto.UserDto;
import online.davidcoldea.backend.service.UserService;
import online.davidcoldea.backend.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto) , HttpStatus.CREATED);
    }

    @GetMapping("/users")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();
        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping("/users/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<UserDto> updateUser(@PathVariable Long id , @RequestBody UserDto updatedUserDto) {
        UserDto newUserDto = userService.updateUser(id , updatedUserDto);
        return ResponseEntity.ok(newUserDto);
    }

    @GetMapping("/{email}")
    ResponseEntity<UserDto> findMyUserByEmail(@PathVariable String email) {
        UserDto userDto = userService.findMyUserByEmail(email);
        return ResponseEntity.ok(userDto);
    }

}
