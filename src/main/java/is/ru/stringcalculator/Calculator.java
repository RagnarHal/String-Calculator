package is.ru.stringcalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Remember to refactor after each passing test.
public class Calculator {
	public static int addnums(String text){
		if(text == "") {
			return 0;
		}

		// Replace all '\n' with ',' and check if a new delimiter is requested
		// Throws exception if requested delimiter is illegal
		text = handleString(text);
		// Throws exception if "-" is present in the string.
		checkNegativeNumbers(text);
		// Removes all numbers larger than 1000 from the string
		text = removeLargeNumbers(text);
		
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
		String[] numbers = text.split(",");


		return text.split(",");
	}

	private static String handleString(String text) {
		// Replace all newlines with the default delimiter to simplify expression handling
		text = text.replace("\n", ",");

		if(text.startsWith("//[")) {
			// Extract the delimiter string between the brackets
			String delim = text.substring(3, text.indexOf("]"));
			// Check for illegal delimiter
			if(delim.contains("-"))
				throw new IllegalArgumentException("Illegal delimiter: " + delim);
			// Throw away the "//[delimiter]\n" part
			text = text.substring(5 + delim.length());
			// Replace all instances of the new delimiter with the default one
			text = text.replace(delim, ",");
		}

		if (text.startsWith("//")) {
			// Extract the new delimiter
			String delim = text.substring(2, 3);
			// Check for illegal delimiter
			if(delim.contains("-"))
				throw new IllegalArgumentException("Illegal delimiter: " + delim);
			// Throw away the "//[delimiter]\n" part
			text = text.substring(4);
			// Replace all instances of the new delimiter with the default one
			text = text.replace(delim, ",");
		}

		return text;
	}

	private static void checkNegativeNumbers(String text) {
		String[] negs = splitString(text);
		String negatives = "";

		for(String number : negs) {
			if(number.contains("-")) {
				negatives += number + ",";
			}
		}

		if(!negatives.isEmpty()) {
			throw new IllegalArgumentException("Negatives not allowed: " + negatives);
		}
	}

	private static String removeLargeNumbers(String text) {
		StringBuilder fixedString = new StringBuilder();

		String[] nums = splitString(text);

		for(String num : nums) {
			if(toInt(num) <= 1000) {
				fixedString.append(num + ",");
			}
		}

		return fixedString.toString();
	}
}