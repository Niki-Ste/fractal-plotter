import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.math3.complex.Complex;

public class FractalBuilder
{
	public void plot(FractalPlot fractalPlot, FractalEquation fractalEquation, int maxIterations) throws IOException
	{
		BufferedImage bufferedImage = new BufferedImage(fractalPlot.imageWidthPixels, fractalPlot.imageHeightPixels, BufferedImage.TYPE_INT_RGB);

		double coordinateX;
		double coordinateY;
		int pixelX;
		int pixelY;
		Complex z;
		Complex c;

		int iterations;
		for (coordinateX = fractalPlot.minX; coordinateX <= fractalPlot.maxX; coordinateX += fractalPlot.gridResolution)
		{
			for (coordinateY = fractalPlot.minY; coordinateY <= fractalPlot.maxY; coordinateY += fractalPlot.gridResolution)
			{
				iterations = 0;
				c = new Complex(coordinateX, coordinateY);
				z = new Complex(0, 0);


				while (z.abs() < 2 && iterations < maxIterations)
				{
					z = fractalEquation.iterate(z, c);
					iterations++;
				}

				pixelX = fractalPlot.getPixelIndexX(coordinateX);
				pixelY = fractalPlot.getPixelIndexY(coordinateY);

				//on a scale of 0 - 1
				double divergenceSpeed = 1 - ((double) iterations / (double) maxIterations);

				bufferedImage.setRGB(pixelX, pixelY, getColor(divergenceSpeed).getRGB());
			}
		}

		try (FileOutputStream fileOutputStream = new FileOutputStream("mandelbrot.png"))
		{
			ImageIO.write(bufferedImage, "png", fileOutputStream);
		}
	}

	public Color getColor ( double scaleZeroToOne)
	{
		if (scaleZeroToOne == 0)
		{
			//so we don't have a huge red area which is a bit hard to look at
			return Color.BLACK;
		}

		double hue = scaleZeroToOne * 0.7; // the 0.7 means we are using hues between red (0) and blue (0.7)

		return Color.getHSBColor((float) hue, (float) 0.9, (float) 0.9);
	}
}
