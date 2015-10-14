package is.ru.stringcalculator;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

    @Test
    public void testTwoNumbers() {
        assertEquals(7, Calculator.addnums("4,3"));
    }

    @Test
    public void testThreeNumbers() {
        assertEquals(17, Calculator.addnums("4,3,10"));
    }

    @Test
    public void testNewlineDelim() {
        assertEquals(7, Calculator.addnums("4\n3"));
    }

    @Test
    public void testMixedDelim() {
        assertEquals(17, Calculator.addnums("4,3\n10"));
    }

    @Test
    public void testCustomDelim() {
        assertEquals(3, Calculator.addnums("//;\n1;2"));
    }

    @Test
    public void testNegativeOneNumber() {
        Boolean threwException = false;
        try {
            Calculator.addnums("-3");
        }
        catch(IllegalArgumentException ex) {
            threwException = true;
            //out.print("\nException message for testNegativeOneNumber: " + ex.getMessage() + "\n");
        }
        assertTrue(threwException);
    }

    @Test
    public void testNegativeTwoNumbers() {
        Boolean threwException = false;
        try {
            Calculator.addnums("-4,-3");
        }
        catch(IllegalArgumentException ex) {
            threwException = true;
            //out.print("\nException message for testNegativeTwoNumbers: " + ex.getMessage() + "\n");
        }
        assertTrue(threwException);
    }

    @Test
    public void testNegativeNumbersWithCustomDelim() {
        Boolean threwException = false;
        try {
            Calculator.addnums("//;\n1;-2");
        }
        catch(IllegalArgumentException ex) {
            threwException = true;
            //out.print("\nException message for testNegativeNumbersWithCustomDelim: " + ex.getMessage() + "\n");
        }
        assertTrue(threwException);
    }


    @Test
    public void testNegSignAsDelimiter() {
        Boolean threwException = false;
        try {
            Calculator.addnums("//-\n5-3");
        }
        catch(IllegalArgumentException ex) {
            threwException = true;
            //out.print("\nException message for testNegSignAsDelimiter: " + ex.getMessage() + "\n");
        }
        assertTrue(threwException);
    }

    @Test
    public void testLargeNumber() {
        assertEquals(6, Calculator.addnums("1001,6"));
    }

    @Test
    public void test1000() {
        assertEquals(1006, Calculator.addnums("1000,6"));
    }

    @Test
    public void testLargeNumberWithCustomDelimiter() {
        assertEquals(3, Calculator.addnums("//;\n2000;3"));
    }

    @Test
    public void testLargeNumberWithNegativeNumbers() {
        Boolean threwException = false;
        try {
            Calculator.addnums("5000,-3, 5");
        }
        catch(IllegalArgumentException ex) {
            threwException = true;
            //out.print("\nException message for testNegSignAsDelimiter: " + ex.getMessage() + "\n");
        }
        assertTrue(threwException);
    }

    @Test
    public void testLargeNumberWithIllegalDelimiter() {
        Boolean threwException = false;
        try {
            Calculator.addnums("//-\n5000-3-5");
        }
        catch(IllegalArgumentException ex) {
            threwException = true;
            //out.print("\nException message for testNegSignAsDelimiter: " + ex.getMessage() + "\n");
        }
        assertTrue(threwException);
    }
}