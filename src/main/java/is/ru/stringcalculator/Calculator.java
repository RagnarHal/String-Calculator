package is.ru.stringcalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Remember to refactor after each passing test.
public class Calculator {
	//This is the only function that is being tested.


	public static int addnums(String text){
		if(text == "") {
			return 0;
		}

		String[] tokens = text.split(",");

		int sum = 0;

		for(String number : tokens) {
			sum += toInt(number);
		}

		return sum;
	}


/* Helpers */
	private static int toInt(String num) {
		return Integer.parseInt(num);
	}
}