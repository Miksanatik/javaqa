import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Test()
public class FactorialTest {
    @Test(dataProvider = "factorialData",
            testName = "Positive numbers and 0 checking")
    public void testFactorial(int n, long expected) {
        long actual = Factorial.factorial(n);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "negativeNumbers",
            expectedExceptions = IllegalArgumentException.class,
            testName = "Negative numbers checking")
    public void testFactorialNegative(int n) {
        long actual = Factorial.factorial(n);
    }

    @DataProvider
    public Object[][] negativeNumbers() {
        return new Object[][] {
                {-5},
                {Integer.MIN_VALUE},
                {-1}
        };
    }
    @DataProvider
    public Object[][] factorialData() {
        return new Object[][] {
                {0, 1},
                {1, 1},
                {5, 120},
        };
    }
}