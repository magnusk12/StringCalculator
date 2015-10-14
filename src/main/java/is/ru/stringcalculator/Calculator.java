package is.ru.stringcalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class Calculator {
	public static int add(String text) {
		// clean text of white spaces
		String textW = text.replaceAll("\\s+","");
		String splitChar;
		String[] tokens;

		if (textW.equals(""))
			return 0;
		else {		// split string, even though it has only ne number...
			if (textW.startsWith("//") ) {
				Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(text);
				m.matches();
				splitChar = m.group(1);
				textW = m.group(2);
			} else {
				splitChar = ",";
			}

			tokens = splitString(textW, splitChar);
			checkIfListContainsMinus(tokens);
			return sumOfTokens(tokens);
		}
	}

	private static void checkIfListContainsMinus(String[] tokens) {
		boolean inclMinus = false;
		String stringOfMinusNumbers = "";
		for (int i=0; i<tokens.length; i++) {
			if (toInt(tokens[i]) < 0) {
				inclMinus = true;
				stringOfMinusNumbers = stringOfMinusNumbers.concat(tokens[i]).concat(",");
			}
		}
		if (inclMinus) {
			throw new RuntimeException("Negatives not allowed: " + 
				stringOfMinusNumbers.substring(0,stringOfMinusNumbers.length()-1) );
		}
	}


	private static int sumOfTokens(String[] tokens){
		int answer = 0;
		for (int i=0; i< tokens.length; i++) {
			answer += toInt(tokens[i]);
		}
		return answer;
	}

	private static String[] splitString(String text, String splitChar) {
		return text.split(Pattern.quote(splitChar));
	}


	private static int toInt(String text) {
		int answer = 0;
		boolean minus = false;
		List<Integer> minusNumbersList = new ArrayList<Integer>();
		try {
			answer = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			// do some error handling 
			System.out.println("Illegal input, exiting " + text);
			System.exit(0);

		}
		return answer;
	}

	public static void main (String[] args) {
		add(args[0]);
	}

}
