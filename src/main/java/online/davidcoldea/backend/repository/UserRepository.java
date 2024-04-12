package online.davidcoldea.backend.repository;

import online.davidcoldea.backend.dto.UserDto;
import online.davidcoldea.backend.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findMyUserByEmail(String email);
}
