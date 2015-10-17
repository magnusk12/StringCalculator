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
		else {		// split string, even though it has only one number...
			if (textW.startsWith("//") ) {
				Matcher m = Pattern.compile("//(\\[*.*\\]*)\n(.*)").matcher(text);
				m.matches();
				splitChar = m.group(1);
				textW = m.group(2);
			} else {
				splitChar = ",";	// default split char
			}
			// split input string into tokens
			tokens = splitString(textW, splitChar);
			// throw error if string contains minus numbers
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
				// build string of all minus numbers
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
		if (splitChar.startsWith("[")) {
			// count number of brackets = number of splitters
			int countBracket = splitChar.length() - splitChar.replace("[","").length();
			// only one bracket
			if (countBracket <= 1) {
				int closePos = splitChar.indexOf("]");
				splitChar = splitChar.substring(1,closePos);
				return text.split(Pattern.quote(splitChar));
			} else {	// many brackets
				String tmpText = text;
				String tmpSplitChar = splitChar;
				for (int i=0; i<countBracket; i++) {
					int closePos = tmpSplitChar.indexOf("]");
					String thisSplit = tmpSplitChar.substring(1,closePos);
					tmpSplitChar = tmpSplitChar.substring(closePos+1,tmpSplitChar.length());
					// fake new splitter
					tmpText = tmpText.replace(thisSplit, ",");
				}
				return tmpText.split(Pattern.quote(","));
			}
		} else {	// no bracket
			return text.split(Pattern.quote(splitChar));
		}
	}


	private static int toInt(String text) {
		int answer = 0;
		boolean minus = false;
		try {
			answer = Integer.parseInt(text);
			if (answer > 1000) {
				answer = 0;
			}
		} catch (NumberFormatException e) {
			// do some error handling 
			System.out.println("Illegal input, exiting " + text);
			System.exit(0);

		}
		return answer;
	}
}
