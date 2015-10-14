package is.ru.stringcalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Remember to refactor after each passing test.
public class Calculator {
	// Regex for the default delimiter
	static String delim = "[,\n]";

	public static int addnums(String text){
		if(text == "") {
			return 0;
		}

		text = handleString(text);
		return sum(splitString(text));
	}


	/* Helpers */
	private static int toInt(String num) {
		return Integer.parseInt(num);
	}

	private static int sum(String[] nums) {
		int sum = 0;

		for(String number : nums) {
			sum += toInt(number);
		}

		return sum;
	}

	private static String[] splitString(String text) {
		return text.split(delim);
	}

	private static String handleString(String text) {
		if (text.startsWith("//")) {
			delim = delim.replace(',', text.charAt(2));
			text = text.substring(4);
		}

		return text;
	}
}