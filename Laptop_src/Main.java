
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tran
 */
public class Main {
    public static void main(String[] args) {
        
    
    LaptopList ll=new LaptopList();
    Scanner sc=new Scanner(System.in);
    utils utl=new utils();
    int chon;
    String id=null;
    do{
            System.out.println("1.Add");
            System.out.println("2.Search");
            System.out.println("3.Print");
            System.out.println("4.Exit");
            chon=utl.getInt("Please choose: ", "", "");
            switch(chon){
                case 1:
                    ll.add();
                    
                    break;
                case 2:
                    id=utl.getString("Enter id: ", "");
                    ll.search(id);
                    break;
                case 3:
                    ll.display();
                    break;
                case 4:
                    break;
            }
    }while(chon!=4);
}
}
