import org.apache.commons.math3.complex.Complex;

public interface FractalEquation
{
	Complex iterate(Complex z, Complex c);
}
