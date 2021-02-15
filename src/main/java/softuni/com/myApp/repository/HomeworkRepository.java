package softuni.com.myApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.com.myApp.model.Entities.Homework;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long> {
}
