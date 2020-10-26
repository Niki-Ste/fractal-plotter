package equations;

import org.apache.commons.math3.complex.Complex;

import plotter.ColorMode;
import plotter.FractalCanvas;

// https://en.wikipedia.org/wiki/Burning_Ship_fractal
public class BurningShip extends FractalEquation
{
	public BurningShip()
	{
		this.recommendedCanvas = new FractalCanvas(-2.5, 1.5, -1.8, 1, 0.005);
		this.recommendedColorMode = ColorMode.ByDivergenceSpeedSquared;
	}

	@Override
	public int iterate(Complex complexCoordinate, int maxIterations)
	{
		int iterations = 0;

		Complex z = complexCoordinate;

		while(z.abs() < chaoticThreshold && iterations < maxIterations)
		{
			double newZReal = (z.getReal() * z.getReal()) - (z.getImaginary() * z.getImaginary()) + complexCoordinate.getReal();
			double newZImaginary = Math.abs(2 * z.getReal() * z.getImaginary()) + complexCoordinate.getImaginary();

			z = new Complex(newZReal, newZImaginary);
			iterations++;
		}

		return iterations;
	}
}
