package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
//b. An empty string will return 0.
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.addnums(""));
	}

    @Test
    public void testOneNumber() {
        assertEquals(3, Calculator.addnums("3"));
    }
}
