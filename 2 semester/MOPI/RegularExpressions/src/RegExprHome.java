import java.util.Set;
import java.util.HashSet;
public class RegExprHome {
	public static Boolean onlyOdd(String str) {
		long countA = str.chars().filter(ch -> ch == 'a').count();
		long countB = str.chars().filter(ch -> ch == 'b').count();

		return str.matches("[ab]*") && countA % 2 != 0 && countB % 2 != 0;
	}
	public static boolean isIden(String word){
		return word.matches("[a-zA-Z_$][a-zA-Z_$0-9]*");
	}
	public static int cntIden(String str){
		int count = 0;
		String[] words = str.split("\\s+");
		for (String word : words) {
			if (isIden(word)) {
				count++;
			}
		}
		return count;
	}
	public static int distIden(String str){
		Set<String> identifiers = new HashSet<>();
		String[] words = str.split("\\s+");
		for (String word : words) {
			if (isIden(word)) {
				identifiers.add(word);
			}
		}
		return identifiers.size();
	}
}
