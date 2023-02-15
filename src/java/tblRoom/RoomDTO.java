/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblRoom;

import java.io.Serializable;

/**
 *
 * @author lehuuhieu
 */
public class RoomDTO implements Serializable {

    private int id, amount, price, hotelId;
    private String type, hotelName;

    public RoomDTO() {
    }

    public RoomDTO(int id, int amount, int price, int hotelId, String type) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.hotelId = hotelId;
        this.type = type;
    }

    public RoomDTO(int id, int amount, int price, int hotelId, String type, String hotelName) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.hotelId = hotelId;
        this.type = type;
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
