/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author DELL
 */
public class Reccomended {
    public class Node {
        Node next;
        User data;
        String Book;
        String author;


        Node(User d, String b, String a) {
            data = d;
            Book = b;
            author = a;
            next = null;
        }

        Node(User d, String b) {
            this(d, b, "");
        }

    }

    Node front;
    Node rear;
    String book;
    String author;

    public Reccomended() {
        front = rear = null;
    }

    public void enqueue(String s, User obj, String a) {
        book = s;
        author = a;
        Node nn = new Node(obj, book, author);
        Node temp;
        Node prev;
        if (front == null && rear == null) {
            front = nn;
            rear = nn;
            //System.out.println(nn.data.username + "1");
        }else if(front == rear) {
            if (nn.data.member){
                if(front.data.member){
                    rear = nn;
                }
                else{
                    front = nn;
                }
            }
            else{
                rear = nn;
            }
            front.next = rear;
        }
        
        else {
            temp = front;
            prev = front;
            if (!nn.data.member) {
                rear.next = nn;
                rear = nn;
                //System.out.println("2");
            } else {
                while (temp != null && temp.data.member) {
                    prev = temp;
                    temp = temp.next;
                }
                if (temp == front) {
                    nn.next = front;
                    front = nn;
                } else if (prev == rear) {
                    //System.out.println("3");
                    rear = nn;
                } else {
                    prev.next = nn;
                    nn.next = temp;
                }
            }
        }
    }


    public String toString() {
        String s = "";
        Node temp = front;
        while (temp != null) {
            s = s + temp.Book + "  " + temp.author + " \n";
            temp = temp.next;
        }
        return s;
    }

    public boolean isEmpty() {
        return (front == null && rear == null);
    }

    public void dequeue() {
        if (isEmpty()) {
            return;
        } else {
            Node temp = front;
            if (front.next == null) {
                temp.data = front.data;
                front = rear = null;
            } else if (front.next != null) {
                temp.data = front.data;
                front = front.next;
            }

        }
    }

}
