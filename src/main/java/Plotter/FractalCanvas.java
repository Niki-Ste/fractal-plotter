package Plotter;

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

	public FractalCanvas(double minX, double maxX, double minY, double maxY, double gridResolution)
	{
		this.minX = minX;
		this.maxX = maxX;

		this.minY = minY;
		this.maxY = maxY;

		this.gridResolution = gridResolution;

		setImageSize();
	}

	public void setImageSize()
	{
		this.imageWidthPixels = (int) ((Math.abs(minX) / gridResolution) + (Math.abs(maxX) / gridResolution));
		this.imageHeightPixels = (int) ((Math.abs(minY) / gridResolution) + (Math.abs(maxY) / gridResolution));
	}

	public int getPixelIndexX(double coordinateX)
	{
		return (int) (((coordinateX - minX) / (maxX - minX)) * imageWidthPixels);
	}

	public int getPixelIndexY(double coordinateY)
	{
		return (int) (((coordinateY - minY) / (maxY - minY)) * imageHeightPixels);
	}
}
