/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.cart;

import haway.tbl_tea.Tbl_TeaDTO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author haway
 */
public class CartDTO implements Serializable {
    private String customerName;
    private Map<String,Tbl_TeaDTO> cart;

    public CartDTO(String customerName, Map<String, Tbl_TeaDTO> cart) {
        this.customerName = customerName;
        this.cart = cart;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Map<String, Tbl_TeaDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, Tbl_TeaDTO> cart) {
        this.cart = cart;
    }
    
    
    public void add (Tbl_TeaDTO dto) {
        if (cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(dto.getTeaID())) {
            int quantity = this.cart.get(dto.getTeaID()).getQuantity();
            dto.setQuantity(quantity+1);
        }
        cart.put(dto.getTeaID(), dto);
    }
    
    public void delete (String id) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
    
    public void update (String id, Tbl_TeaDTO dto) {
        if (this.cart != null) {
            if (this.cart.containsKey(id)) {
                this.cart.replace(id, dto);
            }
        }
    }    
    
}
