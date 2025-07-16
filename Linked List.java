import java.util.ArrayList;

public class Main {

    // print a LL
    public static void printLL(Node head) {
        Node<Integer> curr = head;
        while (curr!=null) {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Check if a number exists or not in a LL
    public static boolean checkData(Node head, int x) {
        Node<Integer> curr = head;
        while (curr!=null) {
            if (curr.data.equals(x)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // Check if a number exists or not in a LL. If it does, then delete it
    public static Node deleteData(Node head, int x) {
        // the return type is node which means it will return the starting point of the new LL after deletion
        Node curr = head;
        if (head.data.equals(x)) {
            // if the first node itself is x
            return head.next;
        }
        // while (curr!=null && curr.next!=null && curr.next.next!=null) {
        //     // you want to exit the loop in the 2nd last node itself
        // }
        while (curr!=null && curr.next!=null) {
            // based on the logic below, I want to exit the loop in the last node itself and not in null
            // because curr.next.data will throw NullPointerException
            if (curr.next.data.equals(x)) {
                // if this is true that means I am standing on the previous node from the node I want to delete
                curr.next = curr.next.next;
                // I have deleted the node successfully
            }
            curr = curr.next;
        }
        return head;
    }

    public static Node insertData(Node head, int index, int x) {
        // the return type is node which means it will return the starting point of the new LL after addition
        if (index==0) {
            // if index is 0, only then the head of the new LL is different from the head of the old LL
            Node<Integer> newNode = new Node<>(x);
            newNode.next = head;
            return newNode;
        }
        int i = 0; // i in counting the indices
        Node curr = head;
        while (curr!=null) {
            if (i==index-1) {
                // I will stop at the index just before where I have to insert x
                Node newnNode = new Node(x);
                newnNode.next = curr.next;
                curr.next = newnNode;
            }
            curr = curr.next;
            ++i;
        }
        return head;
    }
    public static void main(String[] args) {
        // ArrayList<Integer> arr = new ArrayList<>();
        DynamicArray arr = new DynamicArray();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.set(2, 30);
        for (int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();

        Node<Integer> a = new Node<>(10);
        Node<Integer> b = new Node<>(20);
        Node<Integer> c = new Node<>(30);
        Node<Integer> d = new Node<>(40);
        Node<Integer> e = new Node<>(50);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        // the above entire LL can be accessed by variable a

        printLL(a);
        System.out.println(checkData(a, 50));
        // a = deleteData(a, 50);
        a = insertData(a, 4, 70);
        printLL(a);
        System.out.println(checkData(a, 50));
    }
}

class Node<T> {
    T data; // the data that is stored in this node
    Node next;
    Node(T data) {
        this.data = data;
    }
    Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class DynamicArray {
    private int[] arr = new int[10];
    private int size = 0;

    public int size() {
        return size;
    }

    public int get(int index) {
        if (index<0 || index>=size) {
            return -1;
        }
        return arr[index];
    }

    public void set(int index, int element) {
        if (index<0 || index>=size) {
            return;
        }
        arr[index] = element;
    }

    private void increaseLength() {
        int[] temp = new int[(int)Math.round(arr.length*1.5)];
        for (int i=0; i<size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void add(int element) {
        if (size==arr.length) {
            increaseLength();
        }
        arr[size] = element;
        ++size;
        // size is storing the number of elements and also storiung the next index 
        // in which I have to store the next element
    }
}