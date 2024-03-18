package regul;

import java.util.*;
import java.util.regex.*;

public class Algorithm {
	private ArrayList <Rule> base = null;
    // ... fields
	
	public Algorithm (String allRules){
		// ... statements
		base = null;
	}
	
	public String eval(String begin, int cnt){
        // ...statements 
		return "undefined";
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
	// .... methods
	// ......
	// ......
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
