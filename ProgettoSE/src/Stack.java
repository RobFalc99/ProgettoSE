
import java.util.LinkedList;

/*  Stack.java
    23-nov-2021
    12.43.25    */
/**
 * A LIFO collection
 *
 * @param <E> The generic type of the elements in the LIFO collection
 */
public class Stack<E> {

    private LinkedList<E> list;

    /**
     * An empty constructor
     */
    public Stack() {
        list = new LinkedList<>();
    }

    /**
     * Add a new element at the top of the collection
     *
     * @param c The element to add in the collection
     */
    public void push(E c) {
        list.push(c);
    }

    /**
     * Remove the last element added into the collection
     *
     * @return The element removed from the collection
     */
    public E pop() {
        return list.pop();
    }

    /**
     * Return the last element added into the collection
     *
     * @return The element at the top of the collection
     */
    public E top() {
        return list.get(0);
    }

    /**
     * Return the second last element added into the collection
     *
     * @return The element after the top of the collection
     */
    public E secondLast() {
        return list.get(1);
    }

    /**
     * Check if the collection is empty
     *
     * @return True if the collection is empty; False otherwise
     */
    public Boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Remove all the elements from the collection
     */
    public void clear() {
        list.clear();
    }

    /**
     * Getter of the list attribute
     *
     * @return The list attribute
     */
    public LinkedList<E> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Stack{" + "list=" + list + '}';
    }

    /**
     * Swap the second last element in the collection with the last one
     */
    public void swapOperand() {
        E last = list.pop();
        E secondLast = list.pop();
        list.push(last);
        list.push(secondLast);
    }

    /**
     * Add a copy of the last element in the collection
     *
     * @return The added element
     */
    public E dupOperand() {
        E res = list.get(0);
        list.push(res);
        return res;
    }

    /**
     * Remove the last element in the collection
     *
     * @return The removed element
     */
    public E dropOperand() {
        E res = list.pop();
        return res;
    }
}
