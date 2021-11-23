
import com.vm.jcomplex.Complex;
import java.util.LinkedList;

/*  Stack.java
    23-nov-2021
    12.43.25
    FALCONE     */

public class Stack{
    
    private LinkedList<Complex> list;

    public Stack() {
        list = new LinkedList<>();
    }
    
    public void push(Complex c){
        list.push(c);
    }
    
    public Complex pop(){
        return list.pop();
    }
    
    public Complex top(){
        return list.getLast();
    }
    
    public Boolean isEmpty(){
        return list.isEmpty();
    }
    
    public void clear(){
        list.clear();
    }

    public LinkedList<Complex> getList() {
        return list;
    }

    
}
