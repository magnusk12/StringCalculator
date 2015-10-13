package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text) {
		if (text.equals(""))
			return 0;
		else if (text.contains(",")) {
			String[] split = text.split(",");
			return (toInt(split[0]) + toInt(split[1]) );
		}
		else
			return (toInt(text));
	}

	private static int toInt(String text) {
		return (Integer.parseInt(text));

	}

}
