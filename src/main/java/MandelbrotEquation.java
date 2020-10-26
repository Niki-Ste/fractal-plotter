import org.apache.commons.math3.complex.Complex;

public class MandelbrotEquation implements FractalEquation
{
	@Override
	public Complex iterate(Complex z, Complex c)
	{
		return z.multiply(z).add(c);
	}
}
