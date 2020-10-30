package plotter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FractalCanvasTest
{
    @Test
    public void testCanvasBoundariesValidity()
    {
        tryDimensions(-2, -3, 2, 3, false);
        tryDimensions(-3, -2, 3, 2, false);
        tryDimensions(-2, -3, 3, 2, false);

        tryDimensions(0.00001, 0.002, -0.00002, -0.00001, true);
        tryDimensions(-3, -2, 2, 3, true);
    }

    private void tryDimensions(double minX, double maxX, double minY, double maxY, boolean expectedValid)
    {
        try
        {
            FractalCanvas fractalCanvas = new FractalCanvas(minX, maxX, minY, maxY, 0.1);
            if (expectedValid)
            {
                Assertions.assertTrue(fractalCanvas.coordinateBoundariesAreValid());
            }
        }
        catch (CanvasBoundariesInvalidException e)
        {
            if (!expectedValid)
            {
                Assertions.assertEquals(e.getMessage(), "The given canvas coordinates are not valid. Maximum values must be larger than minimum values.");
            }
            else
            {
                System.out.println("Expected valid result but returned invalid and threw exception");
                Assertions.fail();
            }
        }
    }
}
