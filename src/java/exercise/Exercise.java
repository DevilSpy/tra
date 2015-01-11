/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;


import java.util.ArrayList;
import java.util.Date;
import javax.validation.constraints.Past;

/**
 *
 * @author Sami
 */
public class Exercise {
    
    private int id;
    
    @Past
    private Date date;
    
    private Float hours;
    private int userid;
    private ArrayList<Integer> userids;

    public ArrayList<Integer> getUserids() {
        return userids;
    }

    public void setUserids(ArrayList<Integer> userids) {
        this.userids = userids;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the hours
     */
    public Float getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(Float hours) {
        this.hours = hours;
    }

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
}
