/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class History {
    HistoryNode top;

    public void insert(String b) {
        HistoryNode newNode = new HistoryNode(b);
        if (top == null) {
            top = newNode;
        } else {
            newNode.input = b;
            newNode.next = top;
            top = newNode;
        }
    }

    public HistoryNode pop() {
        if (isEmpty()) {
            return null;
        } else {
            HistoryNode temp = top;
            top = top.next;
            return temp;
        }
    }
    
    public void clear(){
        top = null;
        
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        String print = "";
        HistoryNode temp = top;
        if (temp == null){
            return "no searches";
        }
        else{
        while (temp != null) {
            print = print + temp.input + "\n"+ "\n";
            temp = temp.next;
        }
        return print;
        }
    }

//    public static void main(String[] args) {
//        History history = new History();
//        history.insert("Harry Potters");
//        history.insert("My Fake Boyfriend");
//        history.insert("IPHONE");
//        System.out.println(history);
//        history.pop();
//        System.out.println();
//        System.out.println(history);
//    }
}

class HistoryNode {
    String input;
    HistoryNode next;

    HistoryNode(String data) {
        this.input = data;
        next = null;
    }
}
