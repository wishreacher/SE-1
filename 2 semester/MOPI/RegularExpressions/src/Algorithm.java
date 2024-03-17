import java.util.*;
import java.util.regex.*;

public class Algorithm {
	private ArrayList <Rule> base;
	
	public Algorithm (String desc){
		base = new ArrayList<>();
		String[] rules = desc.split(";");
		for (String rule : rules) {
			boolean end = rule.contains("->.");
			String[] parts = rule.split("->.|->");
			if (parts.length != 2) {
				base = null;
				return;
			}
			Pattern left = Pattern.compile(parts[0].trim());
			String right = parts[1].trim();
			base.add(new Rule(left, right, end));
		}
	}

	public String eval(String input, int cnt) {
		int replacements = 0;
		for (int i = 0; i < cnt; i++) {
			boolean isReplaced = false;
			for (Rule rule : base) {
				Matcher matcher = rule.left.matcher(input);
				if (matcher.find()) {
					input = matcher.replaceFirst(rule.right);
					isReplaced = true;
					replacements++;
					if (rule.end) {
						return input;
					}
					break;
				}
			}
			if (!isReplaced) {
				break;
			}
		}
		return replacements > cnt ? "undefined" : input;
	}
	public boolean isGood(){ return base != null;}
	private class Rule {
		Pattern left;
		String right;
		boolean end;
		Rule (Pattern sl, String sr, boolean end){
			this.left=sl; this.right= sr; this.end=end;
		}
		@Override
		public String toString() {
			return left + " ->" + (end?".":"") + " " + right;
		}
	}

	@Override
	public String toString() {
		String res="";
		if (base==null) res = "Error Algorithm";  
		else {res= "Algorithm = [";
	        for(int i=0; i<base.size();i++ )
	        	res += "  \n " + base.get(i).toString();
			res += "]";
		}
		return res;
	}
}
