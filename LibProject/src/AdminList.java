/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class AdminList {
   

    Admin head;
      public void insert(int id, String name, String password) {
        Admin admin = new Admin(id , name, password);
        if (head == null) {
            head = admin;
        } else {
            Admin temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = admin;
        }
    }
    
    public Admin find( int id, String password){
        Admin temp;
        temp = head;
        while (temp!= null){
            if (temp.ID == id && temp.password.compareTo(password)==0) return temp;
            temp = temp.next;
        }
        return null;
    }

//    public void delete(String name) {
//        Admin admin = new Admin(name);
//        if (head == null) {
//            return;
//        } else {
//            Admin temp = head;
//            Admin prev = head;
//            while (temp.next != null && !temp.name.equals(name)) {
//                prev = temp;
//                temp = temp.next;
//            }
//            if (temp.next != null && temp.name.equals(name)) {
//                prev.next = temp.next;
//            }
//            if (temp.next == null && temp.name.equals(name)) {
//                prev.next = temp.next;
//            }
//        }
//    }
    
    

    public String toString() {
        String print = "";
        Admin temp = head;
        while (temp != null) {
            print = print + "Name: " + temp.name + " " + "Password: " + temp.password + "\n";
            temp = temp.next;
        }
        return print;
    }
    
    

 

}

