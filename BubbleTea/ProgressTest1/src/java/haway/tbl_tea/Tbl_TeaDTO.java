/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.tbl_tea;

import java.io.Serializable;

/**
 *
 * @author haway
 */
public class Tbl_TeaDTO implements Serializable {
    private String teaID;
    private String name;
    private float price;
    private int quantity;

    public Tbl_TeaDTO(String teaID, String name, float price, int quantity) {
        this.teaID = teaID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTeaID() {
        return teaID;
    }

    public void setTeaID(String teaID) {
        this.teaID = teaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    } 

    
}
