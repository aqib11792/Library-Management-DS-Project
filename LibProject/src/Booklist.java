/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Booklist {
    
    
    book[] Table; 
    int size =0;
    
    Booklist(int s){
        size =s+(s/3);
        Table=new book[size];
    }
    
     public int Hash( String name, String Author){
         
         String temp = name.toLowerCase() + Author.toLowerCase(); 
        return Math.abs(temp.hashCode())%size;
    }
    public int Rehash(int sum, int i){
        //return (sum+i)%size;
        return (sum+(i*i))%size;
    }
    
    public void insert(book v){
        String name = v.name; String author = v.author;
        int sum = Hash(name, author);
        if (Table[sum]==null || Table[sum].name.equals("***")){
            Table[sum]= v;
        }
        else {
            int i=1 ;int mod = sum;
            while (Table[sum]!=null && !Table[sum].name.equals("***")){
                sum = Rehash(mod,i);
                i++;
            }
            
            Table[sum]= v;
        }
    }
    
     public book search (String name , String author) {
        int index = Hash(name, author); int sum = index; int i =1;
        while(Table[index]!=null){
            if(Table[index].name.equalsIgnoreCase(name) && Table[index].author.equalsIgnoreCase(author)){
                return Table[index];
            }
            else {
                index= Rehash(sum,i);
                i++;
            }
        }
        return null;
    }

    public void delete (String name , String author) {
        int index = Hash(name, author);
        int sum = index; 
        int i =1;
        if (search(name, author)==null){
            
        }
        else {
            while(Table[index]!=null){
                if(Table[index].name.equals(name) && Table[index].author.equals(author) ){
                    Table[index] = new book("***","***"); //random input
                    
                }
                else {
                    index= Rehash(sum,i);
                    i++;
                }
            }
        }
        
    }
    
    
    @Override
    public String toString(){
        String s = "";
        for (int i =0; i < size; i++){
            if (Table[i] != null)
            s = s + Table[i].ToString() + "\n";
        }
        return s;
    }
}
