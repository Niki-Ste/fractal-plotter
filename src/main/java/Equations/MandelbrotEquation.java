package Equations;

import org.apache.commons.math3.complex.Complex;

// The Mandelbrot Set is given by the equation
// z(n+1) = z*z + c
// whereby z is initially zero
// and c is the complex coordinate.
public class MandelbrotEquation implements FractalEquation
{
	@Override
	public int iterate(Complex complexCoordinate, int maxIterations)
	{
		int iterations = 0;

		Complex z = Complex.ZERO;

		while (z.abs() < 2 && iterations < maxIterations)
		{
			z = z.multiply(z).add(complexCoordinate);
			iterations++;
		}

		return maxIterations;
	}
}
