/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblUser;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author lehuuhieu
 */
public class UserDTO implements Serializable {

    private String email, phone, name, address, password, status, role;
    private Timestamp createDate;

    public UserDTO() {
    }

    public UserDTO(String email, String phone, String name, String address, String password, String status, Timestamp createDate, String role) {
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.password = password;
        this.status = status;
        this.createDate = createDate;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

}
