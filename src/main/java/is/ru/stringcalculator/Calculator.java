package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text) {
		// clean text of white spaces
		String textW = text.replaceAll("\\s+","");
		if (textW.equals(""))
			return 0;
		else if (textW.contains(",")) {
			String[] split = textW.split(",");
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
		return (Integer.parseInt(text));

	}

}
