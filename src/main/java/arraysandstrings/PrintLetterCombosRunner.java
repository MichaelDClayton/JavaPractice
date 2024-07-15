package arraysandstrings;
import java.util.List;

public class PrintLetterCombosRunner {

	public static void main(String[] args) {
		arraysandstrings.PrintLetterCombos plc = new arraysandstrings.PrintLetterCombos();
		List<String> result = plc.letterCombinations("234");
		System.out.println(result.toString());
	}
	
}
