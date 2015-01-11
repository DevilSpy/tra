/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import user.Address;
import user.User;

/**
 *
 * @author Sami
 */
public class UserMapper implements RowMapper<User> {
    
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
       
            User user = new User();
            Address address = new Address();
            
            user.setId(rs.getInt("id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setEmail(rs.getString("email"));
            user.setNumber(rs.getString("number"));
            user.setBelt(rs.getString("belt"));
            
            address.setCity(rs.getString("city"));
            address.setStreetaddress(rs.getString("streetaddress"));
            address.setZipcode(rs.getString("zipcode"));
            
            user.setAddress(address);
            
            return user;
            
        }   
}
