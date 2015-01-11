/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import exercise.ExerciseWithParticipants;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author Sami
 */

 public class EWPMapper implements RowMapper<ExerciseWithParticipants> {
    @Override
    public ExerciseWithParticipants mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        ExerciseWithParticipants ewp = new ExerciseWithParticipants();
        
        ewp.setHours(rs.getFloat("exercise.hours"));
        ewp.setFirstname(rs.getString("users.firstname"));
        ewp.setLastname(rs.getString("users.lastname"));
        ewp.setDate(rs.getDate("exercise.date"));
        return ewp;
        
    }
}
