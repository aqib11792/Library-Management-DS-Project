/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class book{
     String name, author;
     Boolean State;
     
     public book(String n , String a){
         name = n; 
         author = a;
         State = false;
         
     }
     
     public String ToString(){
         String s = name + "        " + author;
         return s;
     }
    }