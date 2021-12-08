
import java.text.DecimalFormat;

public class Complex extends org.apache.commons.math3.complex.Complex {

    /**
     * The class constructor, only for real part
     *
     * @param real The input double
     */
    public Complex(double real) {
        super(real);
    }

    /**
     * The class constructor, both for real and imaginary part
     *
     * @param c The input Complex number
     */
    public Complex(org.apache.commons.math3.complex.Complex c) {
        super(c.getReal(), c.getImaginary());
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#,###.########");
        String comp = "";
        if (this.getReal() == 0 && this.getImaginary() == 0) {
            comp += "0";
            return comp;
        }
        if (this.getReal() != 0) {
            comp += formatter.format(this.getReal());
        }
        if (this.getImaginary() < 0) {
            comp += formatter.format(this.getImaginary()) + "i";
        } else if (this.getImaginary() > 0) {
            comp += "+" + formatter.format(this.getImaginary()) + "i";
        }
        return comp;
    }

}
