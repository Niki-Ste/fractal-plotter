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
//			fractalPlotter.plotEscapeTime(new Mandelbrot(), 50, "outputs/mandelbrot.png");
//
//			fractalPlotter.plotEscapeTime(new Julia(new Complex(-0.8, 0.2)), 50, "outputs/julia.png");
//
//			fractalPlotter.plotEscapeTime(new BurningShip(), 50, "outputs/burning_ship.png");
//
			fractalPlotter.plotOrbitTrap(new Mandelbrot(), 50, "outputs/mandelbrot_orbit.png");

			fractalPlotter.plotOrbitTrap(new Julia(new Complex(-0.8, 0.2)), 50, "outputs/julia_orbit.png");

			fractalPlotter.plotOrbitTrap(new BurningShip(), 50, "outputs/burning_ship_orbit.png");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

