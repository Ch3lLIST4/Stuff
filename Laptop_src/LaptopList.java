
import java.util.Scanner;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tran
 */
public class LaptopList {
    TreeSet<Laptop> list=new TreeSet<>();
     String id;
   String name;
   double price;
   int guarantee;
    double promotion;
    utils utl=new utils();
    Scanner sc=new Scanner(System.in);
    private Laptop check(String id){
        for(Laptop l: list){
           if(id.equalsIgnoreCase(l.getId())){
               return l;
           }
         
    }
          return null;
    }
    public void add(){
        do
        id=utl.getString("Enter id: ", "cant empty");
        while(check(id)!=null);
        name=utl.getString("Enter name: ", "cant empty");
        price=utl.getDouble("Enter price: ", "> 0", "be a number");
        guarantee=utl.getInt("Enter guarantee: ", "> 0", "be a number");
        promotion=utl.getDouble("Enter promotion", "", "");
        list.add(new Laptop(id, name, price, guarantee, promotion));
        
    }
    public void search(String id){
       int count=0;
        for(Laptop l:list){
            if(l.getId().contains(id)){
                System.out.println(l);
                count++;
            }
        }
        if(count==0)
            System.out.println("Not Be Found");
    }
    public void display(){
        System.out.format("%s|%s|%s|%s|%s","ID","Name","Price","Guarantee","Promotion");
        for(Laptop l:list){
            System.out.println("");
            System.out.println(l);
        }
    }
}
