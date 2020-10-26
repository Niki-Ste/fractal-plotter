package equations;

import org.apache.commons.math3.complex.Complex;

import plotter.ColorMode;
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
		this.recommendedColorMode = ColorMode.ByDivergenceSpeed;
	}

	@Override
	public Complex iterate(Complex z, Complex complexCoordinate)
	{
		// this is the mathematical heart of the Mandelbrot set
		return z.multiply(z).add(complexCoordinate);
	}

	@Override
	public int calculateEscapeVelocity(Complex complexCoordinate, int maxIterations)
	{
		int iterations = 0;

		Complex z = Complex.ZERO;

		while (z.abs() < chaoticThreshold && iterations < maxIterations)
		{
			z = iterate(z, complexCoordinate);
			iterations++;
		}

		return iterations;
	}

	@Override
	public double calculateLowestDistanceToTrap(Complex complexCoordinate, Complex trap, int maxIterations)
	{
		double distance = 1e20;
		double distanceToTrap;
		int iterations = 0;

		Complex z = Complex.ZERO;

		while (iterations < maxIterations)
		{
			z = iterate(z, complexCoordinate);
			iterations++;

			distanceToTrap = z.subtract(trap).abs();
			if (distanceToTrap < distance)
			{
				distance = distanceToTrap;
			}
		}
		return distance;
	}
}
