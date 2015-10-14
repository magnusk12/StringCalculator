package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
//import org.junit.*;

public class CalculatorTest {

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}

	@Test
	public void testEmpty() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testEmptywith space() {
		assertEquals(0, Calculator.add(" "));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void testOneNumber11space() {
		assertEquals(1, Calculator.add(" 1"));
	}
	@Test
	public void testOneNumber12() {
		assertEquals(1, Calculator.add(" 1 "));
	}
	@Test
	public void testOneNumber13() {
		assertEquals(1, Calculator.add("1 "));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}
	@Test
	public void testTwoNumbers11space() {
		assertEquals(3, Calculator.add(" 1,2"));
	}
	@Test
	public void testTwoNumbers12space() {
		assertEquals(3, Calculator.add(" 1 ,2"));
	}
	@Test
	public void testTwoNumbers13space() {
		assertEquals(3, Calculator.add("1, 2"));
	}
	@Test
	public void testTwoNumbers14space() {
		assertEquals(3, Calculator.add("1, 2 "));
	}
	@Test
	public void testTwoNumbers15space() {
		assertEquals(3, Calculator.add("1 , 2"));
	}
	@Test
	public void testTwoNumbers16space() {
		assertEquals(3, Calculator.add(" 1 , 2 "));
	}


}
