/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblHotel;

import java.io.Serializable;

/**
 *
 * @author lehuuhieu
 */
public class HotelDTO implements Serializable {

    private int id;
    private String name, area;

    public HotelDTO() {
    }

    public HotelDTO(int id, String name, String area) {
        this.id = id;
        this.name = name;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
