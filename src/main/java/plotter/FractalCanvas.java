package plotter;

import org.apache.commons.math3.complex.Complex;

public class FractalCanvas
{
	public double minX;
	public double minY;
	public double maxX;
	public double maxY;

	//this defines the delta in x or y there is for one pixel
	public double gridResolution;

	public int imageWidthPixels;
	public int imageHeightPixels;

	public FractalCanvas(double minX, double maxX, double minY, double maxY, double gridResolution) throws CanvasBoundariesInvalidException
	{
		this.minX = minX;
		this.maxX = maxX;

		this.minY = minY;
		this.maxY = maxY;

		this.gridResolution = gridResolution;

		if (!coordinateBoundariesAreValid())
		{
			throw new CanvasBoundariesInvalidException("The given canvas coordinates are not valid. Maximum values must be larger than minimum values.");
		}

		setImageSize();
	}

	boolean coordinateBoundariesAreValid()
	{
		if (maxX <= minX) return false;
		if (maxY <= minY) return false;
		return true;
	}

	public void setImageSize()
	{
		this.imageWidthPixels = (int) ((maxX - minX) / gridResolution);
		this.imageHeightPixels = (int) ((maxY - minY) / gridResolution);
	}

	public int getPixelIndexX(double coordinateX)
	{
		return (int) (((coordinateX - minX) / (maxX - minX)) * imageWidthPixels);
	}

	public int getPixelIndexY(double coordinateY)
	{
		return (int) (((coordinateY - minY) / (maxY - minY)) * imageHeightPixels);
	}

	public double calculateMaximumDistanceFromOrigin()
	{
		double maxAbsY = Math.max(Math.abs(minY), Math.abs(maxY));
		double maxAbsX = Math.max(Math.abs(minX), Math.abs(maxX));

		return new Complex(maxAbsX, maxAbsY).abs();
	}
}
