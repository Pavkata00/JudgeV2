package softuni.com.myApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.com.myApp.model.Entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("SELECT u.username FROM User u " +
            "GROUP BY u.username")
    List<String> findAllUsernames();

    Optional<User> findByUsername(String username);
}
