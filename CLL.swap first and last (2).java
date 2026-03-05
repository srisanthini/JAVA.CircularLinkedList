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

    // insert
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

    // display
    void display(){
        Node temp = head;

        do{
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        while(temp != head);

        System.out.println();
    }

    // swap first and last
    void swapFirstLast(){

        if(head == null || head.next == head)
            return;

        Node temp = head;

        while(temp.next != head){
            temp = temp.next;
        }

        int t = head.data;
        head.data = temp.data;
        temp.data = t;
    }
}

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        CircularLL list = new CircularLL();

        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            list.insert(val);
        }

        System.out.print("Before Swap: ");
        list.display();

        list.swapFirstLast();

        System.out.print("After Swap: ");
        list.display();
    }
}