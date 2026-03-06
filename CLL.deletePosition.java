import java.util.Scanner;

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

    // Insert
    void insert(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            head.next = head;
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

    // Delete at position
    void deleteAtPosition(int pos){

        if(head == null || pos <= 0)
            return;

        // delete first node
        if(pos == 1){

            if(head.next == head){
                head = null;
                return;
            }

            Node last = head;

            while(last.next != head){
                last = last.next;
            }

            head = head.next;
            last.next = head;
            return;
        }

        Node temp = head;
        int count = 1;

        while(count < pos-1 && temp.next != head){
            temp = temp.next;
            count++;
        }

        if(temp.next == head)
            return;

        temp.next = temp.next.next;
    }

    // Display
    void display(){

        if(head == null)
            return;

        Node temp = head;

        do{
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        while(temp != head);
    }
}

public class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        CircularLL list = new CircularLL();

        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }

        int pos = sc.nextInt();

        list.deleteAtPosition(pos);

        list.display();
    }
}