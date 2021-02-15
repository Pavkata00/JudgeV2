package softuni.com.myApp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.com.myApp.model.Entities.Exercise;
import softuni.com.myApp.model.serviceModels.ExerciseServiceModel;
import softuni.com.myApp.repository.ExerciseRepository;
import softuni.com.myApp.service.ExerciseService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseServiceModel exerciseServiceModel) {
        this.exerciseRepository.save(this.modelMapper.map(exerciseServiceModel, Exercise.class));
    }

    @Override
    public List<String> getAllNames() {
        return this.exerciseRepository.getAllExNames();
    }

    @Override
    public boolean checkIfLate(String exercise) {
        Exercise exerciseEntity = this.exerciseRepository.findByName(exercise).orElse(null);

        return exerciseEntity.getDueDate().isBefore(LocalDateTime.now());
    }

    @Override
    public Optional<Exercise> findByName(String exercise) {
        return exerciseRepository.findByName(exercise);
    }

}
