/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Userlist {
  
    
    User root;
    Reccomended bookRecommend;
    //public Userlist Customer;

    Userlist() {
        root = null;
        bookRecommend = new Reccomended();
        
     
    }

    public void setBookRecommend(String s, User u, String a) {
        bookRecommend.enqueue(s, u ,a);
    }

    public void insert(String u, String p, boolean m, int i) {
        User nn = new User(u, p, m, i);
        if (root == null) {
            root = nn;
        } else {
            User temp = root;
            User prev = root;
            while (temp != null) {
                prev = temp;
                if (nn.ID >= temp.ID) temp = temp.right;
                else temp = temp.left;
            }
            if (nn.ID >= prev.ID) prev.right = nn;
            else prev.left = nn;
        }
        balanceFactor(nn, root, root);

    }

    public void balanceFactor(User n, User temp, User prev) {
        int rsto = 0;
        int lsto = 0;
        if (n.ID != temp.ID) {
            int BF;
            if (n.ID >= temp.ID) {
                balanceFactor(n, temp.right, temp);
            } else {
                balanceFactor(n, temp.left, temp);
            }
            rsto = heightSubtree(temp.right);

            lsto = heightSubtree(temp.left);

            temp.bf = rsto - lsto;

            if (temp.bf < 0) {
                temp.bf = temp.bf * -1;
            }

            if (temp.bf >= 2) {
                if (n.ID < temp.ID) {
                    if (n.ID < temp.left.ID) {
                        rotateRight(prev, temp, temp.left);

                    } else if (n.ID > temp.left.ID) {
                        rotateLeft(temp, temp.left, temp.left.right);
                        rotateRight(prev, temp, temp.left);
                    }
                } else if (n.ID > temp.ID) {
                    if (n.ID > temp.right.ID) {
                        rotateLeft(prev, temp, temp.right);
                    } else if (n.ID < temp.right.ID) {
                        rotateRight(temp, temp.right, temp.right.left);
                        rotateLeft(prev, temp, temp.right);
                    }
                }
            }
        } else {
            rsto = heightSubtree(temp.right);
            lsto = heightSubtree(temp.left);
            n.bf = rsto - lsto;
            if (n.bf < 0) {
                n.bf = n.bf * -1;
            }
        }
    }

    public int heightSubtree(User t) {
        int heightLeft;
        int heightRight;
        if (t != null) {
            heightLeft = heightSubtree(t.left);
            heightRight = heightSubtree(t.right);
            return Math.max(heightLeft, heightRight) + 1;
        } else return 0;
    }

    public void rotateRight(User gr, User pr, User ch) {
        if (pr != root) {
            if (pr.ID > gr.ID) {
                gr.right = ch;
                pr.left = ch.right;
                ch.right = pr;
            } else {
                gr.left = ch;
                pr.left = ch.right;
                ch.right = pr;
            }
        } else {
            root = ch;
            pr.left = ch.right;
            ch.right = pr;
        }
        ch.bf = heightSubtree(ch);
        pr.bf = heightSubtree(pr);
    }

    public void rotateLeft(User gr, User pr, User ch) {
        if (pr != root) {
            if (pr.ID > gr.ID) {
                gr.right = ch;
                pr.right = ch.left;
                ch.left = pr;
            } else {
                gr.left = ch;
                pr.right = ch.left;
                ch.left = pr;
            }
        } else {
            root = ch;
            pr.right = ch.left;
            ch.left = pr;
        }
        ch.bf = heightSubtree(ch);
        pr.bf = heightSubtree(pr);
    }
    
    

    public User find(int key, String password) {
        //String[] s = new String[2];
        if (root == null) return null;
        else {
            User temp = root;
            while (temp != null && (temp.ID != key)) {
                if (temp.ID > key) {
                    temp = temp.left;
                } else if (temp.ID < key) {
                    temp = temp.right;
                }
            }
            if (temp != null && temp.ID == key) {
                if (temp.password.compareTo(password)==0) return temp;
            } 
            
        }
        return null;
    }
}
