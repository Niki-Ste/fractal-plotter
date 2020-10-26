package equations;

import org.apache.commons.math3.complex.Complex;

import plotter.FractalCanvas;

// The Mandelbrot Set is given by the equation
// z(n+1) = z*z + c
// whereby z is initially zero
// and c is the complex coordinate.
public class Mandelbrot extends FractalEquation
{
	public Mandelbrot()
	{
		this.recommendedCanvas = new FractalCanvas(-2.3, 1, -1.3, 1.3, 0.005);
	}

	@Override
	public int iterate(Complex complexCoordinate, int maxIterations)
	{
		int iterations = 0;

		Complex z = Complex.ZERO;

		while (z.abs() < chaoticThreshold && iterations < maxIterations)
		{
			z = z.multiply(z).add(complexCoordinate);
			iterations++;
		}

		return iterations;
	}
}
