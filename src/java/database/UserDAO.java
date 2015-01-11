/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
import javax.sql.DataSource;

import user.*;
/**
 *
 * @author Sami
 */
public interface UserDAO {
    
    // Method to initialize database resources ie. connection
    public void setDataSource(DataSource ds);
    
    // Method to create a record in users table
    public void create(User user);
    
    // Method to list down a record from the users table corresponding to a passed id
    public User getUser(int id);
    
    // Method to list down all the records from users table
    public List<User> listUsers();
    
    // Method to delete a record from the users table
    public void delete(int id);
    
    // Method to update a record in the users table
    public void update(User user);
    
    // Method to get all hours of user
    public Float userHours(int id);
    
}
