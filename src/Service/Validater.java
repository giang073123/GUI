/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author Admin
 */
public class Validater {
    
    public Validater(){}
    
    
    public boolean validate_CCCD(String cccd){
       if(cccd.length()!=5) return false;
       
       
       try {
          Integer.parseInt(cccd);
       } catch (NumberFormatException nfe) {
          return false;
        }
        return true;
    }
    
    public boolean validate_Ma_Ho(String Ma_Ho){
        try {
          Integer.parseInt(Ma_Ho);
       } catch (NumberFormatException nfe) {
          return false;
        }
        return true;
    }
    
    
    public static void main(String args[]){
        Validater v = new Validater();
        System.out.println(v.validate_CCCD("12420"));
    }
}
