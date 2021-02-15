package softuni.com.myApp.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.com.myApp.model.binding.ExerciseAddBindingModel;
import softuni.com.myApp.model.serviceModels.ExerciseServiceModel;
import softuni.com.myApp.service.ExerciseService;

import javax.validation.Valid;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    private final ModelMapper modelMapper;
    private final ExerciseService exerciseService;

    public ExerciseController(ModelMapper modelMapper, ExerciseService exerciseService) {
        this.modelMapper = modelMapper;
        this.exerciseService = exerciseService;
    }

    @GetMapping("add")
    public String add(Model model) {
        if (!model.containsAttribute("exerciseAddBindingModel")) {
            model.addAttribute("exerciseAddBindingModel", new ExerciseAddBindingModel());
        }
        return "exercise-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ExerciseAddBindingModel exerciseAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("exerciseAddBindingModel", exerciseAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.exerciseAddBindingModel", bindingResult);

            return "redirect:add";
        }
        this.exerciseService.addExercise(this.modelMapper.map(exerciseAddBindingModel, ExerciseServiceModel.class));

        return "redirect:/";
    }
}
