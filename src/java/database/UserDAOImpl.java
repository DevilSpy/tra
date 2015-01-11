/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import user.*;
/**
 *
 * @author Sami
 */
public class UserDAOImpl {
    
    private DataSource dataSource;
    private JdbcTemplate template;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
    }
    
    public void create(User user) {
        
        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        String email = user.getEmail();
        String number = user.getNumber();
        String belt = user.getBelt();
        String streetaddress = user.getAddress().getStreetaddress();
        String city = user.getAddress().getCity();
        String zipcode = user.getAddress().getZipcode();
        
        String SQL = "INSERT INTO users (firstname, lastname, email, number, streetaddress, city, zipcode, belt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        template.update(SQL, firstname, lastname, email, number, streetaddress, city, zipcode, belt);
        
    }
    
    public User getUser(int id) {
        
        String SQL = "SELECT * FROM users where id = ?";
        
        User user = template.queryForObject(SQL, new Object[]{id}, new UserMapper());
        
        return user;
        
    }
    
    public List<User> listUsers() {
        
        String SQL = "SELECT * FROM users";
        
        List<User> users = template.query(SQL, new UserMapper());
        
        return users;
    }
    
    public void delete(int id) {
        
        String SQL = "DELETE FROM users where id = ?";
        
        template.update(SQL, id);
    }
    
    public void update(User user) {
        
        int id = user.getId();
        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        String email = user.getEmail();
        String number = user.getNumber();
        String belt = user.getBelt();
        String streetaddress = user.getAddress().getStreetaddress();
        String city = user.getAddress().getCity();
        String zipcode = user.getAddress().getZipcode();
        
        String SQL = "UPDATE users SET firstname = ?, lastname = ?, email = ?, number = ?, streetaddress = ?, city = ?, zipcode = ?, belt = ? WHERE id = ?";
        
        template.update(SQL, firstname, lastname, email, number, streetaddress, city, zipcode, belt, id);
    }
    
    public Float userHours(int id) {
        
        String SQL = "SELECT SUM(hours) AS hours FROM exercise WHERE userid = " + id;
        
        Float hours = template.queryForObject(SQL, Float.class);
        
        return hours;
        
    }
}
