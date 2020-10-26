package Equations;

import org.apache.commons.math3.complex.Complex;

public interface FractalEquation
{
	// returns the number of iterations needed to escape past the threshold,
	// or maxIterations if it did not
	int iterate(Complex complexCoordinate, int maxIterations);
}
