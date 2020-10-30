import java.io.IOException;

import equations.Mandelbrot;
import plotter.CanvasBoundariesInvalidException;
import plotter.ColorMode;
import plotter.FractalCanvas;
import plotter.FractalPlotter;

public class App
{
	public static void main(String[] args)
	{
		FractalPlotter fractalPlotter = new FractalPlotter();

		try
		{
//			fractalPlotter.plotEscapeTime(new Mandelbrot(), 50, "outputs/mandelbrot.png");

			FractalCanvas fractalCanvas = new FractalCanvas(-1, -0.6, 0, 0.4, 0.001);
			fractalPlotter.plotEscapeTime(new Mandelbrot(), fractalCanvas, ColorMode.ByDivergenceSpeed, 50, "outputs/mandelbrot_detail.png");
//
//			fractalPlotter.plotEscapeTime(new Julia(new Complex(-1, 0)), 50, "outputs/julia_-1.png");
//
//			fractalPlotter.plotEscapeTime(new BurningShip(), 50, "outputs/burning_ship.png");
//
//			fractalPlotter.plotOrbitTrap(new Mandelbrot(), 50, "outputs/mandelbrot_orbit.png");

//			fractalPlotter.plotOrbitTrap(new Julia(new Complex(-0.8, 0.2)), 50, "outputs/julia_orbit.png");

//			fractalPlotter.plotOrbitTrap(new BurningShip(), 50, "outputs/burning_ship_orbit.png");
		}
		catch (IOException | CanvasBoundariesInvalidException e)
		{
			e.printStackTrace();
		}
	}
}

