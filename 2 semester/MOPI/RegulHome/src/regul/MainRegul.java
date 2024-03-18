package regul;

import java.util.Arrays;

public class MainRegul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----------onlyOdd-----------");
		String[] str= {"ab","aab", "abbaabbabaaa"};
		for (int i=0; i <str.length; i++)
			System.out.println("\"" + str[i] + "\"  => " + RegExprHome.onlyOdd(str[i]));
		System.out.println("----------isIden-----------");
		String[] str1= {"ab","1aab","c_ab"};
		String[] str2= {" ab  8vb , kl  ","a 2a *a_", ""};
		for (int i=0; i <str1.length; i++)
			System.out.println("\"" + str1[i] + "\" => " + RegExprHome.isIden(str1[i]));
		System.out.println("---------cntIden--------");
		for (int i=0; i <str2.length; i++)
			System.out.println("\"" + str2[i] + "\" cnt= " + RegExprHome.cntIden(str2[i]));
		System.out.println("----------distIden-----------");
		for (int i=0; i <str2.length; i++)
			System.out.println("\"" + str2[i] + "\"  dist= "+ RegExprHome.distIden(str2[i]));	
		
		String[] desc = {"  a -> bc",
			" ->. abc", "ca->ac ; cb -> bc; c->. abb; -> c ",
			"a-> bc ; b->. c  c->.; - > a"
		};
		String [][] data = {{"", "ai", "caia"},{"", "ai", "caia"},{"abc"}, {"ab"}
		};
		System.out.println("---------Algorithm--------");
		for(int i=0; i<desc.length; i++){
			Algorithm test = new Algorithm(desc[i]);
			System.out.println("Algor " + i + " => \n" + test.toString());
			if (test.isGood()){
				for (int j =0; j<data[i].length; j++){
					System.out.println("\"" + data[i][j] + "\" => " +  test.eval(data[i][j],100));
				}
			}	
		}
	}

}
