
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Data {
    public Userlist customer = new Userlist();
    public Booklist library = new Booklist(950);
    public AdminList employee = new AdminList();
    
    public Data(){
        this.read_data();
    }
    
    
    public void read_data(){
        BookDataInsert();
        UserDataInsert();
        AdminDataInsert();
       
    }
    
    public void  BookDataInsert(){
        try {
            File dict = new File("Books.txt");
            Scanner sc = new Scanner(dict);
            int count = 0;

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isBlank()) {
                    String[] splitted = line.split("  ", 2);
                    book temp = new book(splitted[0],splitted[1]);
//                    System.out.println(temp.name);
                    library.insert(temp);
                    count++;
                }                  
            }
            //System.out.println(count); //total word count
            sc.close();
            
        } catch (FileNotFoundException ff) {

            System.out.println("File Not Found");

        }
       
    }
    
    public void UserDataInsert(){
//     customer.insert("aqib", "aqib123", true, 123);
//     customer.insert("burhan", "burhan234", false, 234 );
//     customer.insert("zuhair", "zuhair345", false, 345);
        try{
            File f = new File("UserData.txt");
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String l = sc.nextLine().trim();
                if (!l.isBlank()) {
                String[] splitline = l.split("  ",4);
                boolean b = false;
                if(splitline[2].equals("TRUE")) b = true;
                int val = Integer.parseInt(splitline[3]);
                String UN = splitline[0];
                String Password = splitline[1];
                customer.insert(UN,Password,b,val);
               // System.out.println(customer.toString());
                }
            }
            sc.close();
        }
        catch (FileNotFoundException ff){
            System.out.println("File Not Found");
        }
    
    }
    
    public void AdminDataInsert(){
        employee.insert(01, "ali", "ali01");
        employee.insert(02, "ahmed", "ahmed02");
    }
    
}
