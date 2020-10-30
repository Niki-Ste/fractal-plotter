package equations;

import org.apache.commons.math3.complex.Complex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import plotter.CanvasBoundariesInvalidException;

class MandelbrotTest
{

    @Test
    void testIteration() throws CanvasBoundariesInvalidException
    {
        Mandelbrot mandelbrot = new Mandelbrot();

        Assertions.assertEquals(Complex.ZERO ,mandelbrot.iterate(Complex.ZERO, Complex.ZERO));
        Assertions.assertEquals(Complex.ZERO ,mandelbrot.iterate(Complex.valueOf(-2, -2), Complex.valueOf(-2, -2)));
    }

    @Test
    void testConvergenceBehaviour() throws CanvasBoundariesInvalidException
    {
        Mandelbrot mandelbrot = new Mandelbrot();
        int maxIterations = 15;

        //stays close to origin for all 15 iterations
        double escapeVelocity1 = mandelbrot.calculateEscapeVelocity(Complex.ZERO, maxIterations);
        Assertions.assertEquals(maxIterations, escapeVelocity1);

        //instantly runs away
        double escapeVelocity2 = mandelbrot.calculateEscapeVelocity(Complex.valueOf(-3, -3), 15);
        Assertions.assertEquals(1, escapeVelocity2);

        //fringe, semi-chaotic
        double escapeVelocity3 = mandelbrot.calculateEscapeVelocity(Complex.valueOf(-1, 0.33000000000000024), 15);
        Assertions.assertEquals(12, escapeVelocity3);
    }
}
