
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task1.Sec;

class SecTest {

    private static final double DELTA = 1e-4;

    @Test
    void testSecApproxAtZero() {
        //sec(0) = 1
        Assertions.assertEquals(1.0, Sec.secApprox(0), DELTA);
    }

    @Test
    void testSecApproxAtPiOverThree() {
        // sec(pi/3) = 2
        Assertions.assertEquals(2.0, Sec.secApprox(Math.PI / 3), DELTA);
    }

    @Test
    void testSecApproxAtPiOverSix() {
        // sec(pi/6) = 2 / sqrt(3)
        Assertions.assertEquals(2 / Math.sqrt(3), Sec.secApprox(Math.PI / 6), DELTA);
    }

    @Test
    void testSecApproxNearPiOverTwo() {
        // sec(pi/2) неопределено, но мы должны обрабатывать значения близкие к π/2
        // т.к. значение стремится к бесконечности, то проверяем, что оно большое
        Assertions.assertTrue(Math.abs(Sec.secApprox(Math.PI / 2 - 0.01)) > 100);
        Assertions.assertTrue(Math.abs(Sec.secApprox(Math.PI / 2 + 0.01)) > 100);
    }

    @Test
    void testSecApproxAtTwoPi() {
        // sec(2π) = 1
        Assertions.assertEquals(1.0, Sec.secApprox(2 * Math.PI), DELTA);
    }

    @Test
    void testSecApproxAtMinusFivePi() {
        // sec(-5π) = -1
        Assertions.assertEquals(-1.0, Sec.secApprox(-5 * Math.PI), DELTA);
    }

    @Test
    void testSecApproxAtNegativeAngles() {
        // секанс должен быть одинаковым и для положительных, и для отрицательных углов
        Assertions.assertEquals(Sec.secApprox(-Math.PI / 3), Sec.secApprox(Math.PI / 3), DELTA);
        Assertions.assertEquals(Sec.secApprox(-Math.PI / 6), Sec.secApprox(Math.PI / 6), DELTA);
    }
}
