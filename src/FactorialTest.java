import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FactorialTest {
    @DisplayName("Positive numbers and 0 checking")
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "5, 120"})
    public void testFactorialPositive(int n, int expected) {
        assertEquals(expected, Factorial.factorial(n));
    }
    
    @DisplayName("Negative numbers checking")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -5})
    public void testFactorialNegative(int n) {
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> Factorial.factorial(n));
    }
}