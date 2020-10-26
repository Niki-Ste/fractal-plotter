package equations;

import org.apache.commons.math3.complex.Complex;

import plotter.ColorMode;
import plotter.FractalCanvas;

public abstract class FractalEquation
{
	public FractalCanvas recommendedCanvas;

	//this is the value at which the divergence threshold is passed
	public int chaoticThreshold = 2;

	public ColorMode recommendedColorMode = ColorMode.ByDivergenceSpeed;

	//the mathematical core of the respective algorithm
	public abstract Complex iterate(Complex z, Complex complexCoordinate);

	// returns the number of iterations needed to escape past the threshold,
	// or maxIterations if it did not
	public abstract int calculateEscapeVelocity(Complex complexCoordinate, int maxIterations);

	public abstract double calculateLowestDistanceToTrap(Complex complexCoordinate, Complex trap, int maxIterations);
}
