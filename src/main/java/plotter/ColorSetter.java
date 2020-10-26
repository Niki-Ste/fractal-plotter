package plotter;

import java.awt.Color;

public class ColorSetter
{
	//if z does not diverge into chaotic behaviour within the max iterations,
	// it is said it is part of the 'set'
	public Color isInSetColor = Color.BLACK;
	public ColorMode colorMode;

	public ColorSetter(ColorMode colorMode)
	{
		this.colorMode = colorMode;
	}

	public int determinePixelRGB(double divergenceSpeed)
	{
		return determinePixelColor(divergenceSpeed).getRGB();
	}

	public Color determinePixelColor(double divergenceSpeed)
	{
		if (colorMode != null)
		{
			double hue;
			switch (colorMode)
			{
				default:
				case Binary:
					if (divergenceSpeed == 0) return Color.BLACK;
					else return Color.WHITE;
				case ByDivergenceSpeed:
					if (divergenceSpeed == 0) return isInSetColor;
					hue = divergenceSpeed * 0.7; // the 0.7 means we are using hues between red (0) and blue (0.7)
					break;
				case ByDivergenceSpeedSquared:
					if (divergenceSpeed == 0) return isInSetColor;
					hue = (divergenceSpeed * divergenceSpeed) * 0.7; // the 0.7 means we are using hues between red (0) and blue (0.7)
			}
			return Color.getHSBColor((float) hue, (float) 0.9, (float) 0.9);
		}
		return null;
	}
}
