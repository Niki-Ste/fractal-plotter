package Equations;

import org.apache.commons.math3.complex.Complex;

// z is initially given by the complex coordinate.
// z(n+1) = f(z(n)), whereby the polynomial equation f(z(n)) can be expressed in the form
// f(z(n)) = z*z + c
// whereby c is a constant complex number (not the complex coordinate!!)
// c therefore defines the 'set'
public class JuliaSet implements FractalEquation
{
	public Complex polynomial;

	public JuliaSet (Complex polynomial)
	{
		this.polynomial = polynomial;
	}

	@Override
	public int iterate(Complex complexCoordinate, int maxIterations)
	{
		int iterations = 0;
		Complex z = complexCoordinate;

		while (z.abs() < 2 && iterations < maxIterations)
		{
			z = z.multiply(z).add(polynomial);
			iterations++;
		}

		return iterations;
	}
}
