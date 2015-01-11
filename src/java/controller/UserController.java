/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;

import database.*;
import java.util.List;
import javax.validation.Valid;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
public class UserController {
    
    // database things
    ApplicationContext context = new ClassPathXmlApplicationContext("/src/contextConfig.xml");
    UserDAOImpl template = (UserDAOImpl)context.getBean("userDAOImpl");
    
    // users listing
    @RequestMapping(value="/Users/", method = RequestMethod.GET)
    public ModelAndView listUsers() {
        
        List<User> listUser = template.listUsers();
        
        // set total hours to user
        for (int i=0; i<listUser.size(); i++) {
            User user = listUser.get(i);
            int id = user.getId();
            Float hours = template.userHours(id);
            user.setTotalHours(hours);
        }
        
        ModelAndView model = new ModelAndView("user/Users");
        
        model.addObject("listUser", listUser);
        
        return model;
        
    }
    
    // form to add new user
    @RequestMapping(value="/Users/userForm.html", method = RequestMethod.GET)
    public ModelAndView getUserForm() {
        
        ModelAndView model = new ModelAndView("user/UserForm");
        
        return model;
    }
    
    // form submitting success
    @RequestMapping(value="/Users/submitUserForm.html", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("user/UserForm");
            return model;
        } else {
        
            template.create(user);
        
            ModelAndView model = new ModelAndView("user/UserFormSuccess");
        
            return model;
        }
    }
    
    // editing user
    @RequestMapping(value="/Users/editUser.html", method = RequestMethod.GET)
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        
        ModelAndView model = new ModelAndView("user/EditUser");
        
        return model;
    }
    
    // saving edited user
    @RequestMapping(value="/Users/saveUser.html", method = RequestMethod.POST)
    public ModelAndView saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("user/EditUser");
            return model;
        }  else {
            
            template.update(user);
        
            ModelAndView model = new ModelAndView("user/SaveUserSuccess");
        
            return model;
        }
    }
    
    // delete user
    @RequestMapping(value="/Users/deleteUser.html", method = RequestMethod.GET)
    public ModelAndView deleteUser(@ModelAttribute("user") User user) {
        
        template.delete(user.getId());
        
        ModelAndView model = new ModelAndView("user/DeleteUserSuccess");
        
        return model;
    }
} 
