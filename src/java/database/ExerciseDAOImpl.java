/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import exercise.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sami
 */
public class ExerciseDAOImpl {
    private DataSource dataSource;
    private JdbcTemplate template;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
    }
    
    public void create(Exercise exercise) {
        
        Date date = exercise.getDate();
        Float hours = exercise.getHours();
        int userid = exercise.getUserid();
       
        String SQL = "INSERT INTO exercise (date, hours, userid) VALUES (?, ?, ?)";

        template.update(SQL, date, hours, userid);
        
    }
    
    public void createMultiple(Exercise exercise) {
        
        Date date = exercise.getDate();
        Float hours = exercise.getHours();
        int userid = exercise.getUserid();
        ArrayList<Integer> userids = exercise.getUserids();
        
        for(int i=0; i<userids.size(); i++) {
            
            int uid = userids.get(i);
            
            String SQL = "INSERT INTO exercise (date, hours, userid) VALUES (?, ?, ?)";

            template.update(SQL, date, hours, uid);
        
        }
    }
    
    // listing exercises with participants
    public List<List> listRecentExercises() {
        
        // get all exercise dates
        String SQL1 = "SELECT DISTINCT date FROM exercise ORDER BY date DESC";
        List<Date> dates = template.query(SQL1, new RowMapper<Date>() {
            
            @Override
            public Date mapRow(ResultSet rs, int rowNum) throws SQLException {
                Date dates;
                dates = rs.getDate("date");
                return dates;
            }
        });
      
        List<ExerciseWithParticipants> ewpList = new ArrayList<>();
        List<List> listaa = new ArrayList<>();
       
        // get all users and hours from exercises
       for(int i=0; i<dates.size(); i++) {
            Date date = dates.get(i);
            String SQL = "SELECT users.firstname, users.lastname, exercise.hours, exercise.date FROM exercise INNER JOIN users ON exercise.userid=users.id WHERE exercise.date = '" + date + "' ORDER BY firstname ASC";
            ewpList = template.query(SQL, new EWPMapper());
            listaa.add(ewpList);
        }
       
        return listaa;
    }
    
    public Exercise getExercise(int id) {
        
        String SQL = "SELECT * FROM exercise where id = ?";
        
        Exercise exercise = template.queryForObject(SQL, new Object[]{id}, new ExerciseMapper());
        
        return exercise;
        
    }
    
    public List<Exercise> listExercises() {
        
        String SQL = "SELECT * FROM exercise";
        
        List<Exercise> exercises = template.query(SQL, new ExerciseMapper());
        
        return exercises;
    }
    
    public void delete(int id) {
        
        String SQL = "DELETE FROM exercise where id = ?";
        
        template.update(SQL, id);
    }
    
    public void update(Exercise exercise) {
        
        int id = exercise.getId();
        Date date = exercise.getDate();
        Float hours = exercise.getHours();
        int userid = exercise.getId();
        
        String SQL = "UPDATE exercise SET date = ?, hours = ?, userid = ? WHERE id = ?";
        
        template.update(SQL, date, hours, userid, id);
    }
}
