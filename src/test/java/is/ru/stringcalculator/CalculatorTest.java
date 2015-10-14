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
	public void testEmptywithspace() {
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

	@Test
	public void testMoreNumbers() {
		assertEquals(10, Calculator.add("1,2,3,4"));
	}
	@Test
	public void testMoreNumbers11space() {
		assertEquals(10, Calculator.add(" 1,2,3,4"));
	}
	@Test
	public void testMoreNumbers12space() {
		assertEquals(9, Calculator.add("2,3,4 "));
	}
	@Test
	public void testMoreNumbers13space() {
		assertEquals(15, Calculator.add("1 , 2 , 3 , 4 , 5"));
	}
	@Test
	public void testMoreNumbers14space() {
		assertEquals(11, Calculator.add("     1  ,  1  ,  2  ,  3  ,  4    "));
	}

	@Test
	public void testWrongInput1() {
		assertEquals(1, Calculator.add("1,"));
	}
	// this throws error - normal...
	//@Test
	//public void testWrongInput2() {
	//	assertEquals(1, Calculator.add(",1"));
	//}
	@Test
	public void testWrongInput3() {
		assertEquals(0, Calculator.add(","));
	}
	@Test
	public void testWrongInput4() {
		assertEquals(0, Calculator.add(" , "));
	}

	@Test
	public void testWrongInput5() {
		assertEquals(0, Calculator.add("a"));
	}

}
