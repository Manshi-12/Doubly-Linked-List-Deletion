import java.util.*;
public class deleteNodeSmallerThan 
{
    public static void main(String[] args) 
    {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int numberOfElement = sc.nextInt();

        for (int i = 0; i < numberOfElement; i++) 
        {
            System.out.print("Enter element " + (i + 1) + ": ");
            int element = sc.nextInt();
            list.insert(element);
        }

        System.out.print("Enter the value to compare and delete: ");
        int valueToDelete = sc.nextInt();

        System.out.println("Original List:");
        list.display();

        list.deleteNodesSmallerThan(valueToDelete);

        System.out.println("List after deleting nodes smaller than " + valueToDelete + ":");
        list.display();
    }
}


class DoublyLinkedList 
{
    class Node 
    {
        int data;
        Node prev;
        Node next;

        public Node(int data) 
        {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node first = null;

    public void insert(int data)
    {
        Node newNode = new Node(data);
        if (first == null)
        {
            first = newNode;
        }
        else
        {
            Node temp = first;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void deleteNodesSmallerThan(int value) 
    {
        Node temp = first;
        while (temp != null) 
        {
            if (temp.data < value) 
            {
                if (temp.prev != null) 
                {
                    temp.prev.next = temp.next;
                } 
                else 
                {
                    first = temp.next;
                }

                if (temp.next != null) 
                {
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
    }

    public void display() 
    {
        if (first == null)
        {
            System.out.println("List is Empty!!!");
        }
        else
        {
            Node temp = first;
            while (temp != null)
            {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }        
    }
}