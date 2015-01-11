/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ExerciseDAOImpl;
import database.UserDAOImpl;
import exercise.Exercise;
import exercise.ExerciseWithParticipants;
import java.util.List;
import javax.validation.Valid;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import user.User;

/**
 *
 * @author Sami
 */
@Controller
public class ApplicationController {
    
    // database things
    ApplicationContext context = new ClassPathXmlApplicationContext("/src/contextConfig.xml");
    ExerciseDAOImpl extemplate = (ExerciseDAOImpl)context.getBean("exerciseDAOImpl");
    UserDAOImpl ustemplate = (UserDAOImpl)context.getBean("userDAOImpl");
    
    // front page
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView frontPage(@ModelAttribute("user") User user,@ModelAttribute("exercise") Exercise exercise, @ModelAttribute("ewp") ExerciseWithParticipants ewp) {
        
        ModelAndView model = new ModelAndView("app/FrontPage");
        
        return model;
        
    }
    
    // commong objects for front page
    @ModelAttribute
    public void addingCommongObjects(Model model) {
        List<Exercise> listExercises = extemplate.listExercises();
        model.addAttribute("listExercises", listExercises);
        
        List<User> listUsers = ustemplate.listUsers();
        model.addAttribute("listUsers", listUsers);
        
        List<List> lista = extemplate.listRecentExercises();
        model.addAttribute("recentEwp", lista);
      
    }
    
    // saving exercise entry
    @RequestMapping(value="/saveEntry.html", method = RequestMethod.POST)
    public ModelAndView saveEntry(@ModelAttribute("user") User user, @Valid @ModelAttribute("exercise") Exercise exercise, BindingResult result) {
        
        if(result.hasErrors()) {
            ModelAndView model = new ModelAndView("app/FrontPage");
            return model;
        } else {
        
            extemplate.createMultiple(exercise);
        
            ModelAndView model = new ModelAndView("app/SaveEntry");
        
            return model;
        }
    }
    
}
