import org.apache.commons.math3.complex.Complex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Variables extends HashMap<String,Complex>{
    
    /**
     * A constructor which initialize the structure with all the alphabet letters as keys and 0 as values
     */
    public Variables() {
        String alph = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
        ArrayList<String> myListAlph = new ArrayList<>(Arrays.asList(alph.split(",")));
        myListAlph.forEach(s -> {
            this.put(s, new Complex(0));
        });
    }

    /**
     * A constructor which initialize the structure with a String collection passed as keys and 0 as values
     * @param keys  The set of keys to initialize
     */
    public Variables(ArrayList<String> keys) {
        keys.forEach(s -> {
            this.put(s, new Complex(0));
        });
    }
    
    /**
     * Set the value of a variable
     *
     * @param s The input String
     * @param c The input Complex
     * @return The input Complex added to hashMap
     */
    public Complex setVariable(String s, Complex c){
        this.replace(s, c);
        return c;
    }
    
    /**
     *  Return the value associated to a variable
     * 
     * @param s The input String
     * @return The complex associated to the string s
     */
    public Complex getVariable(String s){
       return this.get(s);
    }
    
    /**
     * Changes the value associated with the passed key with the sum between the complex passed and the Complex value associated to the passed key
     * @param s The input String
     * @param c The input Complex
     * @return A Complex that is the sum of the passed complex and the complex value associated to the input string
     */
    public Complex addValue (String s, Complex c){
        Complex c1 = this.get(s);
        Complex result= c.add(c1);
        this.replace(s, result);
        return result;
    }
       public Complex subValue(String s,Complex c){
        Complex x=this.get(s);
        Complex total=x.subtract(c);
        this.replace(s, total);
         return total;
     }
       
}
