package uz.pdp.notuzum.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.notuzum.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    boolean existsByUsername(String username);
}