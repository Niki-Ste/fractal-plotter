import java.io.IOException;

public class App
{
	public static void main(String[] args)
	{
		FractalBuilder fractalBuilder = new FractalBuilder();

		try
		{
			FractalPlot fractalPlot = new FractalPlot(-2.3, 1, -1.5, 1.5, 0.001);
			fractalBuilder.plot(fractalPlot, new MandelbrotEquation(), 50);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

