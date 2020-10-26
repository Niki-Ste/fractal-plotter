import java.io.IOException;

import org.apache.commons.math3.complex.Complex;

import equations.BurningShip;
import equations.Julia;
import equations.Mandelbrot;
import plotter.FractalPlotter;

public class App
{
	public static void main(String[] args)
	{
		FractalPlotter fractalPlotter = new FractalPlotter();

		try
		{
			fractalPlotter.plot(new Mandelbrot(), 50, "outputs/mandelbrot.png");

			fractalPlotter.plot(new Julia(new Complex(-0.8, 0.2)), 50, "outputs/julia.png");

			fractalPlotter.plot(new BurningShip(), 50, "outputs/burning_ship.png");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

