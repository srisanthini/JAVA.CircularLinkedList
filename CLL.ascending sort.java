import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class CircularLL{

    Node head = null;

    void insert(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            newNode.next = head;
        }
        else{

            Node temp = head;

            while(temp.next != head){
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }
    }

    void sort(){

        Node temp = head;

        if(head == null) return;

        do{

            Node index = temp.next;

            while(index != head){

                if(temp.data > index.data){

                    int t = temp.data;
                    temp.data = index.data;
                    index.data = t;
                }

                index = index.next;
            }

            temp = temp.next;

        }while(temp != head);
    }

    void display(){

        Node temp = head;

        if(head == null) return;

        do{
            System.out.print(temp.data + " ");
            temp = temp.next;
        }while(temp != head);
    }
}

public class Main{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        CircularLL list = new CircularLL();

        int n = sc.nextInt();
        
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            list.insert(value);
        }

        list.sort();
        list.display();
    }
}
