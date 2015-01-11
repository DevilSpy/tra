/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
import javax.sql.DataSource;
import exercise.*;
import java.util.Date;

/**
 *
 * @author Sami
 */
public interface ExerciseDAO {
    
    // Method to initialize database resources ie. connection
    public void setDataSource(DataSource ds);
    
    // Method to create a record in exercise table
    public void create(Exercise exercise);
    
    // Method to create multiple entries at one time in exercise table
    public void createMultiple(Exercise exercise);
    
    // Method to list recent exercises and participants
    public List<List> listRecentExercises();
    
    // Method to list down a record from the exercise table corresponding to a passed id
    public Exercise getExercise(int id);
    
    // Method to list down all the records from exercise table
    public List<Exercise> listExercises();
    
    // Method to delete a record from the exercise table
    public void delete(int id);
    
    // Method to update a record in the exercise table
    public void update(Exercise exercise);
    
}

