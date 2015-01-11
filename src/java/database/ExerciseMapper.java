/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import exercise.Exercise;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sami
 */
public class ExerciseMapper implements RowMapper<Exercise> {
    @Override
    public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
        Exercise exercise = new Exercise();
        exercise.setId(rs.getInt("id"));
        exercise.setDate(rs.getDate("date"));
        exercise.setHours(rs.getFloat("hours"));
        exercise.setUserid(rs.getInt("userid"));
        return exercise;
    }
}
