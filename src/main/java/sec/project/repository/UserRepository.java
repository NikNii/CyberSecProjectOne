package sec.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.controller.User;
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
