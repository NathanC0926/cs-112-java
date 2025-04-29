import java.util.*;

public class LLBag implements Bag {

    private class Node {
        Object val;
        Node next;

        Node() {
        }

        Node(Object val) {
            this.val = val;
        }

        Node(Object val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node dummy;
    private int length;

    public LLBag() {
        this.dummy = new Node();
        this.length = 0;
    }

    public boolean add(Object item) {
        if (dummy.next == null)
            dummy.next = new Node(item);
        else {
            Node oldHead = dummy.next;
            dummy.next = new Node(item, oldHead);
        }
        this.length++;
        return true;
    }

    public boolean remove(Object item) {
        if (length == 0) {
            throw new IllegalStateException("the bag is empty");
        }
        Node prev = dummy;
        Node curr = prev.next;

        while (curr != null) {
            Node next = curr.next;
            if (curr.val.equals(item)) {
                prev.next = next;
                curr.next = null;
                this.length--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public boolean contains(Object item) {
        if (length == 0) {
            return false;
        }
        Node curr = dummy.next;

        while (curr != null) {
            if (curr.val.equals(item)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public int numItems() {
        return this.length;
    }

    public Object grab() {
        if (length == 0) {
            throw new IllegalStateException("the bag is empty");
        }
    
        int i = (int) (Math.random() * this.length);
        int counter = 0;
    
        Node curr = dummy.next;
        while (curr != null) {  // Check if curr is null
            if (counter == i)
                return curr.val;
            counter++;
            curr = curr.next;
        }
        
        // If we somehow get here (shouldn't happen with proper random bounds)
        return dummy.next.val;  // Return the head as a fallback
    }

    public Object[] toArray() {
        if (length == 0)
            return new Object[0];

        Object[] arr = new Object[length];
        Node curr = dummy.next;
        int i = 0;
        while (curr != null) {
            arr[i] = curr.val;
            curr = curr.next;
            i++;
        }
        return arr;
    }

    public String toString() {
        String str = "{";

        Node curr = dummy.next;
        while (curr != null) {
            str = str + curr.val;
            if (curr.next != null) {
                str += ", ";
            }
            curr = curr.next;
        }

        str = str + "}";
        return str;
    }

    /* Test the ArrayBag implementation. */
    public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);

        // Create an ArrayBag named bag1.
        System.out.print("number of items in bag 1: ");
        int numItems = scan.nextInt();
        Bag bag1 = new LLBag();
        scan.nextLine(); // consume the rest of the line

        // Read in strings, add them to bag1, and print out bag1.
        String itemStr;
        for (int i = 0; i < numItems; i++) {
            System.out.print("item " + i + ": ");
            itemStr = scan.nextLine();
            bag1.add(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();

        // Select a random item and print it.
        Object item = bag1.grab();
        System.out.println("grabbed " + item);
        System.out.println();

        // Iterate over the objects in bag1, printing them one per line.
        Object[] items = bag1.toArray();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        System.out.println();

        // Get an item to remove from bag1, remove it, and reprint the bag.
        System.out.print("item to remove: ");
        itemStr = scan.nextLine();
        if (bag1.contains(itemStr)) {
            bag1.remove(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
    }
}
