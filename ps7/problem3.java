import java.util.Stack;
import java.util.Queue;

public class problem3 {
    public static void doubleAllStack(Stack<Object> stack, Object item) {
        Stack<Object> s = new Stack<>();
        while (!stack.isEmpty()) {
            Object o = stack.pop();

            if (o.equals(item)) {
                s.push(o);
            }
            s.push(o);
        }
        while (!s.isEmpty()) {
            Object o = s.pop();
            stack.push(o);
        }
    }

    public static void doubleAllQueue(Queue<Object> queue, Object item) {
        LLQueue<Object> q = new LLQueue<>();
        while (!queue.isEmpty()){
            Object o = queue.remove();
            if (o.equals(item)) {
                q.insert(o);
            }
            q.add(o);
        }
        while (!q.isEmpty()) {
            Object o = q.remove();
            queue.add(o);
        }
 
 
    }
    public boolean searchStack(Stack<T> S, Queue<T> Q, T I) {
        boolean found = false;
        
        // search for I
        while (!S.isEmpty()) {
            T item = S.pop();
            if (item.equals(I)) {
                found = true;
            }
            Q.enqueue(item);
        }
        
        // push back to s in reverse 
        while (!Q.isEmpty()) {
            S.push(Q.dequeue());
        }
        

        while (!S.isEmpty()) {
            Q.enqueue(S.pop());
        }
        

        // This restores the original order
        while (!Q.isEmpty()) {
            S.push(Q.dequeue());
        }
        
        return found;
    }
 
    public static void main(String[] args) {
        doubleAllQueue(null,null);
    }
}
