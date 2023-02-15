/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblRoom;

import java.util.HashMap;

/**
 *
 * @author lehuuhieu
 */
public class CartObj {

    private String email;
    private HashMap<String, RoomDTO> cart;

    public CartObj() {
    }

    public CartObj(String email) {
        this.email = email;
        this.cart = new HashMap<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashMap<String, RoomDTO> getCart() {
        return cart;
    }

    public void addToCart(RoomDTO dto) throws Exception {
        if (this.cart.containsKey(String.valueOf(dto.getId()))) {
            int quantity = this.cart.get(String.valueOf(dto.getId())).getAmount() + 1;
            dto.setAmount(quantity);
        }
        this.cart.put(String.valueOf(dto.getId()), dto);
    }

    public float getTotal() {
        int result = 0;
        for (RoomDTO dto : this.cart.values()) {
            result += dto.getPrice() * dto.getAmount();
        }
        return result;
    }

    public void remove(int id) throws Exception {
        if (this.cart.containsKey(String.valueOf(id))) {
            this.cart.remove(String.valueOf(id));
        }
    }

    public void update(int id, int newQuantity) throws Exception {
        if (this.cart.containsKey(String.valueOf(id))) {
            this.cart.get(String.valueOf(id)).setAmount(newQuantity);
        }
    }
}
