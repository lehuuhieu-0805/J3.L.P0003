/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblOrder;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author lehuuhieu
 */
public class OrderDTO implements Serializable {

    private int id, totalPrice;
    private String userEmail, Status;
    private Timestamp date;

    public OrderDTO() {
    }

    public OrderDTO(int id, int totalPrice, String userEmail, String Status, Timestamp date) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.userEmail = userEmail;
        this.Status = Status;
        this.date = date;
    }

    public OrderDTO(int totalPrice, String userEmail, String Status, Timestamp date) {
        this.totalPrice = totalPrice;
        this.userEmail = userEmail;
        this.Status = Status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

}
