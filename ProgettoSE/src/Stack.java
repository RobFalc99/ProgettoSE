
import java.util.LinkedList;

/*  Stack.java
    23-nov-2021
    12.43.25
    FALCONE     */

public class Stack<E>{
    
    private LinkedList<E> list;

    public Stack() {
        list = new LinkedList<>();
    }
    
    public void push(E c){
        list.push(c);
    }
    
    public E pop(){
        return list.pop();
    }
    
    public E top(){
        return list.get(0);
    }
    
    public E secondLast(){
        return list.get(1);
    }
    
    public Boolean isEmpty(){
        return list.isEmpty();
    }
    
    public void clear(){
        list.clear();
    }

    public LinkedList<E> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Stack{" + "list=" + list + '}';
    }

    //==============================LUIGI
    
    
    
    
    //=============================ROB
    
    
    
    //==============================EUG
    
    
    
    //=================================ADO
   
}
