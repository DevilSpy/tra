/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ExerciseDAOImpl;
import exercise.Exercise;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sami
 */
@Controller
public class ExerciseController {
    
    ApplicationContext context = new ClassPathXmlApplicationContext("/src/contextConfig.xml");
    ExerciseDAOImpl template = (ExerciseDAOImpl)context.getBean("exerciseDAOImpl");
    
    // list all exercises
    @RequestMapping(value="/Exercises/", method = RequestMethod.GET)
    public ModelAndView listExercises() {
        
        List<Exercise> listExercises = template.listExercises();
        
        ModelAndView model = new ModelAndView("exercise/Exercises");
        
        model.addObject("listExercises", listExercises);
        
        return model;
    }
}
