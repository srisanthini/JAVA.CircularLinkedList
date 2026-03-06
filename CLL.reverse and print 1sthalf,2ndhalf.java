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

    // insert at end
    void insert(int data){

        Node newNode = new Node(data);

        // first node
        if(head == null){
            head = newNode;
            head.next = head;
            return;
        }

        Node temp = head;

        while(temp.next != head){
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // reverse circular linked list
    void reverse(){

        if(head == null || head.next == head)
            return;

        Node prev = null;
        Node curr = head;
        Node next;

        do{
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;

        }while(curr != head);

        head.next = prev;
        head = prev;
    }

    // split and print
    void splitPrint(int n){

        int firstHalf;

        if(n % 2 == 0)
            firstHalf = n/2;
        else
            firstHalf = (n/2) + 1;

        Node temp = head;

        // first half
        for(int i=0;i<firstHalf;i++){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

        System.out.println();

        // second half
        for(int i=firstHalf;i<n;i++){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}

public class Main{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        CircularLL list = new CircularLL();

        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            list.insert(val);
        }

        list.reverse();

        list.splitPrint(n);
    }
}