package is.ru.stringcalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public static int add(String text) {
		// clean text of white spaces
		String textW = text.replaceAll("\\s+","");
		String splitChar = "";

		if  (text.startsWith("//")) {
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
			m.matches();
			splitChar = m.group(1);
			textW = m.group(2);
		} else {
			splitChar = ",";
		}

		if (textW.equals(""))
			return 0;
		else if (textW.contains(splitChar)) {
			String[] split = textW.split(splitChar);
			int answer = 0;
			for (int i=0; i< split.length; i++) {
				answer += toInt(split[i]);
			}
			return answer;
		}
		else	// no parameters
			return (toInt(textW));
	}

	private static int toInt(String text) {
		int answer = 0;
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
