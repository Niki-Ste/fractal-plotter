package equations;

import org.apache.commons.math3.complex.Complex;

import plotter.CanvasBoundariesInvalidException;
import plotter.ColorMode;
import plotter.FractalCanvas;

// z is initially given by the complex coordinate.
// z(n+1) = f(z(n)), whereby the polynomial equation f(z(n)) can be expressed in the form
// f(z(n)) = z*z + c
// whereby c is a constant complex number (not the complex coordinate!!)
// c therefore defines the 'set'
public class Julia extends FractalEquation
{
	public Complex polynomial;

	public Julia(Complex polynomial) throws CanvasBoundariesInvalidException
	{
		this.polynomial = polynomial;
		this.recommendedCanvas = new FractalCanvas(-2, 2, -1, 1, 0.0005);
		this.recommendedColorMode = ColorMode.ByDivergenceSpeedSquared;
	}

	@Override
	public Complex iterate(Complex z, Complex complexCoordinate)
	{
		return z.multiply(z).add(polynomial);
	}

	@Override
	public int calculateEscapeVelocity(Complex complexCoordinate, int maxIterations)
	{
		int iterations = 0;
		Complex z = complexCoordinate;

		while (z.abs() < chaoticThreshold && iterations < maxIterations)
		{
			z = z.multiply(z).add(polynomial);
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

		Complex z = complexCoordinate;

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
