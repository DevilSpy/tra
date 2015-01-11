/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Sami
 */
public class Address {
    
    private String streetaddress;
    private String city;
    private String zipcode;

    /**
     * @return the streetaddress
     */
    public String getStreetaddress() {
        return streetaddress;
    }

    /**
     * @param streetaddress the streetaddress to set
     */
    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
