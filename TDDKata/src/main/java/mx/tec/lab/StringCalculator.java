package mx.tec.lab;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringCalculator {
	public int add(String numbers) throws IllegalArgumentException {
		Pattern pattern = Pattern.compile("//(.)\n");
		Matcher m = pattern.matcher(numbers);
		String delimiter = ",";
		String prefix = "";
		if(m.find()) {
			prefix = m.group(0);
			delimiter = m.group(1);
		}
		String args[] = numbers.substring(prefix.length()).split(delimiter + "|\n");
		//Empty string case
		if(args.length == 1 && args[0].isBlank()) {
			return 0;
		}
		//Normal case
		int result = 0;
		for(String arg : args) {
			//Checks Negative Numbers
			if(arg.contains("-")) {
				throw new IllegalArgumentException("negatives not allowed " + arg);
			}
			result += Integer.parseInt(arg);
		}
		return result;

	}
}
