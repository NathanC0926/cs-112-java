/*
 * ChainedHashTable.java
 *
 * Computer Science 112, Boston University
 * 
 * Modifications and additions by:
 *     name:
 *     email:
 */

import java.util.*; // to allow for the use of keyArrays.toString() in testing

/*
 * A class that implements a hash table using separate chaining.
 */
public class ChainedHashTable implements HashTable {
    /*
     * Private inner class for a node in a linked list
     * for a given position of the hash table
     */
    private class Node {
        private Object key;
        private LLQueue<Object> values;
        private Node next;

        private Node(Object key, Object value) {
            this.key = key;
            values = new LLQueue<Object>();
            values.insert(value);
            next = null;
        }
    }

    private Node[] table; // the hash table itself
    private int numKeys; // the total number of keys in the table
    private int SIZE; // maximum load factor before resizing

    /* hash function */
    public int h1(Object key) {
        int h1 = key.hashCode() % table.length;
        if (h1 < 0) {
            h1 += table.length;
        }
        return h1;
    }

    /*** Add your constructor here ***/
    public ChainedHashTable(int SIZE) {
        this.table = new Node[SIZE];
        this.SIZE = SIZE;
        this.numKeys = 0;
    }

    /*
     * insert - insert the specified (key, value) pair in the hash table.
     * Returns true if the pair can be added and false if there is overflow.
     */
    public boolean insert(Object key, Object value) {
        /** Replace the following line with your implementation. **/
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }

        int index = h1(key);
        if (this.table[index] == null) {
            this.table[index] = new Node(key, value);
        } else {
            Node curr = this.table[index];
            while (curr != null) {
                if (curr.key.equals(key)) {
                    curr.values.insert(value);
                    return false;
                }
                curr = curr.next;
            }
            Node newNode = new Node(key, value);
            newNode.next = this.table[index];
            this.table[index] = newNode;
        }
        numKeys++;

        return true;
    }

    /*
     * search - search for the specified key and return the
     * associated collection of values, or null if the key
     * is not in the table
     */
    public Queue<Object> search(Object key) {
        /** Replace the following line with your implementation. **/
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }
        int index = h1(key);
        Node curr = this.table[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.values;
            }
            curr = curr.next;
        }

        return null;
    }

    /*
     * remove - remove from the table the entry for the specified key
     * and return the associated collection of values, or null if the key
     * is not in the table
     */
    public Queue<Object> remove(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }

        int index = h1(key);
        if (this.table[index] == null)
            return null;

        Node dummy = new Node(null, null);
        dummy.next = this.table[index]; // Connect dummy to the start of the chain
        Node prev = dummy;
        Node curr = this.table[index];
        Queue<Object> res = null;

        while (curr != null) {
            if (curr.key.equals(key)) {
                // Found the key - save values and remove the node
                res = curr.values;
                prev.next = curr.next; // Skip over the node we're removing
                numKeys--; // Decrement key count
                break; // We've found and removed the key, so we can stop searching
            }

            // Move both pointers forward
            prev = curr;
            curr = curr.next;
        }

        // Update the chain in the table
        this.table[index] = dummy.next;

        return res;
    }

    /*** Add the other required methods here ***/
    public int getNumKeys() {
        return numKeys;
    }

    public double load() {
        return (double) numKeys / SIZE;
    }

    public Object[] getAllKeys() {
        Object[] keyArr = new Object[numKeys];
        int i = 0;
        for (Node head : table) {
            Node curr = head;
            while (curr != null) {
                keyArr[i] = curr.key;
                curr = curr.next;
                i++;
            }
        }
        return keyArr;

    }

    private Object[] getAllVals() {
        Object[] valArr = new Object[numKeys];
        int i = 0;
        for (Node head : table) {
            Node curr = head;
            while (curr != null) {
                valArr[i] = curr.values;
                curr = curr.next;
                i++;
            }
        }
        return valArr;
    }

    public void resize(int NEW_SIZE) {
        if (NEW_SIZE < SIZE)
            throw new IllegalArgumentException("cant resize to a smaller val");
        else if (NEW_SIZE == SIZE)
            return;
        else {
            Object[] keys = getAllKeys();
            Object[] vals = getAllVals();
            int oldNumKeys = numKeys;
            // reset the table
            this.table = new Node[NEW_SIZE];
            this.SIZE = NEW_SIZE;
            this.numKeys = 0;
            for (int i = 0; i < oldNumKeys; i++) {
                insert(keys[i], vals[i]);
            }

        }

    }

    /*
     * toString - returns a string representation of this ChainedHashTable
     * object. *** You should NOT change this method. ***
     */
    public String toString() {
        String s = "[";

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                s += "null";
            } else {
                String keys = "{";
                Node trav = table[i];
                while (trav != null) {
                    keys += trav.key;
                    if (trav.next != null) {
                        keys += "; ";
                    }
                    trav = trav.next;
                }
                keys += "}";
                s += keys;
            }

            if (i < table.length - 1) {
                s += ", ";
            }
        }

        s += "]";
        return s;
    }

    public static void main(String[] args) {
        System.out.println("--- Testing ChainedHashTable class ---");
        System.out.println();

        // TEST INSERT METHOD
        System.out.println("--- Testing method insert ---");
        System.out.println();

        System.out.println("(1) Testing insert with new key");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            boolean results = table.insert("test", 42);
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        System.out.println("(2) Testing insert with duplicate key");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            table.insert("test", 42);
            boolean results = table.insert("test", 100);
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("false");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == false);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        // TEST SEARCH METHOD
        System.out.println("--- Testing method search ---");
        System.out.println();

        System.out.println("(1) Testing search for existing key");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            table.insert("apple", 5);
            Queue<Object> results = table.search("apple");
            System.out.println("actual results:");
            System.out.println(results != null);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results != null);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        System.out.println("(2) Testing search for non-existing key");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            table.insert("apple", 5);
            Queue<Object> results = table.search("banana");
            System.out.println("actual results:");
            System.out.println(results == null);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == null);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        // TEST REMOVE METHOD
        System.out.println("--- Testing method remove ---");
        System.out.println();

        System.out.println("(1) Testing remove for existing key");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            table.insert("apple", 5);
            Queue<Object> results = table.remove("apple");
            System.out.println("actual results:");
            System.out.println(results != null);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results != null);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        System.out.println("(2) Testing remove for non-existing key");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            table.insert("apple", 5);
            Queue<Object> results = table.remove("banana");
            System.out.println("actual results:");
            System.out.println(results == null);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == null);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        // TEST GETNUMKEYS METHOD
        System.out.println("--- Testing method getNumKeys ---");
        System.out.println();

        System.out.println("(1) Testing getNumKeys with empty table");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            int results = table.getNumKeys();
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("0");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == 0);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        System.out.println("(2) Testing getNumKeys after insertions");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            table.insert("apple", 5);
            table.insert("banana", 10);
            int results = table.getNumKeys();
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("2");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == 2);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        // TEST LOAD METHOD
        System.out.println("--- Testing method load ---");
        System.out.println();

        System.out.println("(1) Testing load with empty table");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            double results = table.load();
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("0.0");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == 0.0);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        System.out.println("(2) Testing load after insertions");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            table.insert("apple", 5);
            table.insert("banana", 10);
            double results = table.load();
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("0.4");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == 0.4);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        // TEST GETALLKEYS METHOD
        System.out.println("--- Testing method getAllKeys ---");
        System.out.println();

        System.out.println("(1) Testing getAllKeys with empty table");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            Object[] results = table.getAllKeys();
            System.out.println("actual results:");
            System.out.println(results.length);
            System.out.println("expected results:");
            System.out.println("0");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results.length == 0);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        System.out.println("(2) Testing getAllKeys after insertions");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            table.insert("apple", 5);
            table.insert("banana", 10);
            Object[] results = table.getAllKeys();
            // Sort the results for consistent testing
            Arrays.sort(results);
            String arrayStr = Arrays.toString(results);
            System.out.println("actual results:");
            System.out.println(arrayStr);
            System.out.println("expected results:");
            System.out.println("[apple, banana]");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(arrayStr.equals("[apple, banana]"));
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        // TEST RESIZE METHOD
        System.out.println("--- Testing method resize ---");
        System.out.println();

        System.out.println("(1) Testing resize to larger size");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            table.insert("apple", 5);
            table.insert("banana", 10);
            table.resize(10);
            System.out.println("actual results:");
            int newSize = 10; // We don't have a method to get SIZE directly
            boolean keysPreserved = table.search("apple") != null && table.search("banana") != null;
            System.out.println("Keys preserved: " + keysPreserved);
            System.out.println("expected results:");
            System.out.println("Keys preserved: true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(keysPreserved);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();

        System.out.println("(2) Testing resize to smaller size (should throw exception)");
        try {
            ChainedHashTable table = new ChainedHashTable(5);
            table.insert("apple", 5);
            table.resize(3);
            System.out.println("actual results:");
            System.out.println("No exception thrown");
            System.out.println("expected results:");
            System.out.println("IllegalArgumentException");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(false); // Should not reach here
        } catch (IllegalArgumentException e) {
            System.out.println("CORRECTLY THREW IllegalArgumentException");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(true);
        } catch (Exception e) {
            System.out.println("THREW UNEXPECTED EXCEPTION: " + e);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(false);
        }
        System.out.println();
    }
}
