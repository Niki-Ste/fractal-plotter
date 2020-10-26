package plotter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.math3.complex.Complex;

import equations.FractalEquation;

public class FractalPlotter
{
	public void plot(FractalEquation fractalEquation, int maxIterations, String fileName) throws IOException
	{
		plot(fractalEquation, fractalEquation.recommendedCanvas, fractalEquation.recommendedColorMode, maxIterations, fileName);
	}

	public void plot(FractalEquation fractalEquation, FractalCanvas fractalCanvas, ColorMode colorMode, int maxIterations, String filename) throws IOException
	{
		BufferedImage bufferedImage = new BufferedImage(fractalCanvas.imageWidthPixels, fractalCanvas.imageHeightPixels, BufferedImage.TYPE_INT_RGB);

		colourCanvasByDivergenceSpeed(fractalCanvas, fractalEquation, colorMode, maxIterations, bufferedImage);

		writeFile(filename, bufferedImage);

		bufferedImage.flush();
	}

	private void colourCanvasByDivergenceSpeed(FractalCanvas fractalCanvas, FractalEquation fractalEquation, ColorMode colorMode, int maxIterations, BufferedImage bufferedImage)
	{
		double coordinateX;
		double coordinateY;
		int pixelX;
		int pixelY;
		Complex c;

		ColorSetter colorSetter = new ColorSetter(colorMode);

		for (coordinateX = fractalCanvas.minX; coordinateX <= fractalCanvas.maxX; coordinateX += fractalCanvas.gridResolution)
		{
			for (coordinateY = fractalCanvas.minY; coordinateY <= fractalCanvas.maxY; coordinateY += fractalCanvas.gridResolution)
			{
				c = new Complex(coordinateX, coordinateY);

				int iterations = fractalEquation.iterate(c, maxIterations);

				pixelX = fractalCanvas.getPixelIndexX(coordinateX);
				pixelY = fractalCanvas.getPixelIndexY(coordinateY);

				//on a scale of 0 - 1
				double divergenceSpeed = 1 - ((double) iterations / (double) maxIterations);

				bufferedImage.setRGB(pixelX, pixelY, colorSetter.determinePixelRGB(divergenceSpeed));
			}
		}
	}

	private void writeFile(String filename, BufferedImage bufferedImage) throws IOException
	{
		try (FileOutputStream fileOutputStream = new FileOutputStream(filename))
		{
			ImageIO.write(bufferedImage, "png", fileOutputStream);
		}
	}

	public Color getColor (double scaleZeroToOne)
	{
		if (scaleZeroToOne == 0)
		{
			//so we don't have a huge red area which is a bit hard to look at
			return Color.BLACK;
		}

		double hue = (scaleZeroToOne * scaleZeroToOne) * 0.7; // the 0.7 means we are using hues between red (0) and blue (0.7)

		return Color.getHSBColor((float) hue, (float) 0.9, (float) 0.9);
	}
}
