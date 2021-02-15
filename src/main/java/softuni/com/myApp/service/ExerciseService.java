package softuni.com.myApp.service;

import softuni.com.myApp.model.Entities.Exercise;
import softuni.com.myApp.model.serviceModels.ExerciseServiceModel;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    void addExercise(ExerciseServiceModel exerciseServiceModel);

    List<String> getAllNames();


    boolean checkIfLate(String exercise);

    Optional<Exercise> findByName(String exercise);
}
