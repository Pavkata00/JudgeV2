package softuni.com.myApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.com.myApp.model.Entities.Exercise;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query("SELECT e.name FROM Exercise e " +
            "ORDER BY e.name")
    List<String> getAllExNames();

    Optional<Exercise> findByName(String exercise);
}
