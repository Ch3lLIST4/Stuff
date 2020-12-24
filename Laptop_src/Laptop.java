/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tran
 */
public class Laptop implements Comparable<Laptop>{
    String id;
   String name;
   double price;
   int guarantee;
    double promotion;

    public Laptop(String id, String name, double price, int guarantee, double promotion) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.guarantee = guarantee;
        this.promotion = promotion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public double getPromotion() {
        return promotion;
    }

    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }
    public String toString(){
        return String.format("%s|%s|%f|%d|%f",this.id,this.name,this.price,this.guarantee,this.promotion);
    }

    @Override
    public int compareTo(Laptop o) {
        return this.id.compareToIgnoreCase(o.getId()); //To change body of generated methods, choose Tools | Templates.
    }
        
}
