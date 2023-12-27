/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class User {
  
    String username;
    String password;
    boolean member;
    int ID;
    User right;
    User left;
    int bf;
    book[] borrow;
    
    User(String u, String p, boolean m, int id) {
        username = u;
        password = p;
        member = m;
        ID = id;
        right = null;
        left = null;
        
        if (m){
            borrow = new book[3];
        }
        else borrow = new book[1];
        }
    
    
}
