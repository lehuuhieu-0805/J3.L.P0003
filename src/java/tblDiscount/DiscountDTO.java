/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblDiscount;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author lehuuhieu
 */
public class DiscountDTO implements Serializable {

    private int id, value;
    private String code;
    private Timestamp expiryDate;

    public DiscountDTO() {
    }

    public DiscountDTO(int id, String code, Timestamp expiryDate, int value) {
        this.id = id;
        this.code = code;
        this.expiryDate = expiryDate;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

}
