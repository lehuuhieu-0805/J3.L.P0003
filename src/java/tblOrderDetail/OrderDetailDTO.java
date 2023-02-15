package tblOrderDetail;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lehuuhieu
 */
public class OrderDetailDTO implements Serializable {

    private int id, price, amount, orderId, roomId;
    private String hotelName, roomType;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int id, int price, int amount, int orderId, int roomId, String hotelName, String roomType) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.orderId = orderId;
        this.roomId = roomId;
        this.hotelName = hotelName;
        this.roomType = roomType;
    }

    public OrderDetailDTO(int price, int amount, int orderId, int roomId) {
        this.price = price;
        this.amount = amount;
        this.orderId = orderId;
        this.roomId = roomId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

}
