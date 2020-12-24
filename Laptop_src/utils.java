/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author lehie
 */
public class utils {
     Scanner sc= new Scanner(System.in);
    public String getString(String msg, String warming){
       
        String result="";
        do{
            System.out.println(msg);
            result=sc.nextLine();
            if(result.trim().isEmpty())
                System.out.println(warming);
        }while(result.trim().isEmpty());
        return result;
    }
    
    public int getInt(String msg, String warming, String error){
        int result=0;
        boolean contt=false;
        do{
            try{
                System.out.println(msg);
                result=Integer.parseInt(sc.nextLine());
                if(result<=0)
                    System.out.println(warming);
            }
            catch(NumberFormatException e){
                System.out.println(error);
            }
        }while(result<=0 || contt==true);
    return result;
    }

    public double getDouble(String msg, String warming, String error){
        int result=0;
        boolean contt=false;
        do{
            try{
                System.out.println(msg);
                result=Integer.parseInt(sc.nextLine());
                if(result<=0)
                    System.out.println(warming);
            }
            catch(NumberFormatException e){
                System.out.println(error);
            }
        }while(result<=0 || contt==true);
    return result;
    }
    
      public int getInt1(String msg, String error){
        int result=0;
        boolean contt=false;
        do{
            try{
                System.out.println(msg);
                result=Integer.parseInt(sc.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println(error);
            }
        }while(contt==true);
    return result;
    }
}

