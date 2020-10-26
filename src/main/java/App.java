import java.io.IOException;

import org.apache.commons.math3.complex.Complex;

import Equations.JuliaSet;
import Plotter.FractalCanvas;
import Plotter.FractalPlotter;

public class App
{
	public static void main(String[] args)
	{
		FractalPlotter fractalPlotter = new FractalPlotter();

		try
		{
//			FractalPlot mandelbrotCanvas = new FractalPlot(-2.3, 1, -1.5, 1.5, 0.001);
//			fractalPlotter.plot(mandelbrotCanvas, new MandelbrotEquation(), 50, "mandelbrot.png");

			FractalCanvas juliaCanvas = new FractalCanvas(-2, 2, -1, 1, 0.0005);
			fractalPlotter.plot(juliaCanvas, new JuliaSet(new Complex(-0.8, 0.2)), 50, "julia.png");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

