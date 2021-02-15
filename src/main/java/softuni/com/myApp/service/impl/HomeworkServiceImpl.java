package softuni.com.myApp.service.impl;

import org.springframework.stereotype.Service;
import softuni.com.myApp.model.Entities.Homework;
import softuni.com.myApp.repository.HomeworkRepository;
import softuni.com.myApp.security.CurrentUser;
import softuni.com.myApp.service.ExerciseService;
import softuni.com.myApp.service.HomeworkService;
import softuni.com.myApp.service.UserService;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ExerciseService exerciseService;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, CurrentUser currentUser, UserService userService, ExerciseService exerciseService) {
        this.homeworkRepository = homeworkRepository;
        this.currentUser = currentUser;
        this.userService = userService;
        this.exerciseService = exerciseService;
    }

    @Override
    public void addHomework(String exercise, String gitAddress) {

        Homework homework = new Homework();
        homework.setGitAddress(gitAddress);
        homework.setAddedOn(LocalDateTime.now());
        homework.setExercise(exerciseService.findByName(exercise).orElse(null));
        homework.setAuthor(userService.findById(currentUser.getId()));

        homeworkRepository.save(homework);

    }
}
