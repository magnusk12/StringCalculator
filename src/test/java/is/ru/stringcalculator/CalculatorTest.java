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
	public void testEmptySpaceOnly() {
		assertEquals(0, Calculator.add(" "));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void testOneNumberLeadingSpace() {
		assertEquals(1, Calculator.add(" 1"));
	}
	@Test
	public void testOneNumber12() {
		assertEquals(1, Calculator.add(" 1 "));
	}
	@Test
	public void testOneNumberFallowingSpace() {
		assertEquals(1, Calculator.add("1 "));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}
	@Test
	public void testTwoNumbersSpaceInFrontOfFirstNumber() {
		assertEquals(3, Calculator.add(" 1,2"));
	}
	@Test
	public void testTwoNumbersSpaceBothSidesOfFirstNumber() {
		assertEquals(3, Calculator.add(" 1 ,2"));
	}
	@Test
	public void testTwoNumbersSpaceInFrontOfSecondNumber() {
		assertEquals(3, Calculator.add("1, 2"));
	}
	@Test
	public void testTwoNumbersSpaceAroundSecondNumber() {
		assertEquals(3, Calculator.add("1, 2 "));
	}
	@Test
	public void testTwoNumbersSpaceAfterFirstNoAndBeforeSecondNo() {
		assertEquals(3, Calculator.add("1 , 2"));
	}
	@Test
	public void testTwoNumbersSpaceBetweenAllChars() {
		assertEquals(3, Calculator.add(" 1 , 2 "));
	}

	@Test
	public void testFourNumbers() {
		assertEquals(10, Calculator.add("1,2,3,4"));
	}
	@Test
	public void testFourNumbersWithLeadingSpace() {
		assertEquals(10, Calculator.add(" 1,2,3,4"));
	}
	@Test
	public void testThreeNumbersWithTrailingSpace() {
		assertEquals(9, Calculator.add("2,3,4 "));
	}
	@Test
	public void testFiveNumbersWithSpaces() {
		assertEquals(15, Calculator.add("1 , 2 , 3 , 4 , 5"));
	}
	@Test
	public void testFiveNumbersWithLongSpaces() {
		assertEquals(11, Calculator.add("     1  ,  1  ,  2  ,  3  ,  4    "));
	}

	@Test
	public void testWithNumberMissingAfterLastSplitter() {
		assertEquals(1, Calculator.add("1,"));
	}
	// this throws error - normal...
	//@Test
	//public void testWrongInput2() {
	//	assertEquals(1, Calculator.add(",1"));
	//}
	@Test
	public void testWithOnlySplitterAndNoNumbers() {
		assertEquals(0, Calculator.add(","));
	}
	@Test
	public void testWithOnlySplitterAndNoNumbersWithSpaces() {
		assertEquals(0, Calculator.add(" , "));
	}

	// illegan input exits - normal
	//@Test
	//public void testWrongInput5() {
	//	assertEquals(0, Calculator.add("a"));
	//}
	@Test
	public void testTwoCharsWithNewLineInBetween() {
		assertEquals(3, Calculator.add("1,\n2"));
	}
	@Test
	public void testTwoCharsStartingWithNewLine() {
		assertEquals(3, Calculator.add("\n1,2"));
	}
	@Test
	public void testThreeCharsWithNewLineInBetween() {
		assertEquals(4, Calculator.add("1,2\n ,1"));
	}

	@Test
	public void testThreeCharsWithCustomSplitterSizeOne() {
		assertEquals(6, Calculator.add("//;\n1;2;3"));
	}
	@Test
	public void testFourCharsWithCustomSplitterSizeOne() {
		assertEquals(14, Calculator.add("//;\n1;2;1;10"));
	}

	@Test
	public void testThreeCharsWithCustomSplitterSizeTwo() {
		assertEquals(4, Calculator.add("//pp\n1pp2pp1"));
	}
	@Test
	public void testThreeCharsWithCustomSplitterSizeThree() {
		assertEquals(4, Calculator.add("//sps\n1sps2sps1"));
	}
	@Test
	public void testThreeCharsWithCustomSplitterPlus() {
		assertEquals(4, Calculator.add("//+\n1+2+1"));
	}
	@Test
	public void testThreeCharsWithCustomSplitterMult() {
		assertEquals(4, Calculator.add("//*\n1*2*1"));
	}
}
