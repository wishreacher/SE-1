package lambda;

import java.util.*;
import java.util.stream.*;

public class Book {
	ArrayList <String> authors;
	String titleName;
	int pages;
	Set <String> types;
	String pubName;

	public Book(ArrayList<String> authors, String titleName, int pages, Set<String> types,  String pubName) {
		this.authors = authors;
		this.titleName = titleName;
		this.types = types;
		this.pages = pages;
		this.pubName = pubName;
	}
	public ArrayList<String> getAuthors() {
		return authors;
	}
	public String getTitleName() {
		return titleName;
	}
	public Set<String> getTypes() {
		return types;
	}
	public int getPages() {
		return pages;
	}
	public String getPubName() {
		return pubName;
	}

	public static Stream <Book> library() { return Stream.of(libraryStr()).map(x->toBook(x)); }

	@Override
	public String toString() {
		return "Book [authors=" + authors + ", titleName=" + titleName + ", pages=" + pages
				+ ", types=" + types + ", pubName=" + pubName + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Book other = (Book) obj;
		if(other.authors==null && authors != null) return false;
		if(!authors.equals(other.authors))return false;
		if(!titleName.equals(other.titleName))return false;
		if(pages != other.pages)return false;
		if(other.types==null && types != null) return false;
		if(!types.equals(other.types))return false;
		if(!pubName.equals(other.pubName))return false;
		return true;
	}

	private static Book toBook(String input) {
		String input1 = input.replaceFirst("^\\s*","");  // delete spaces from begin 
		String input2= input1.replaceFirst("\\s*$","");  // delete spaces from end 
		String[] token = input2.split("\\s*,\\s*");      // select components of book
		String[] au = token[0].split("\\s*:\\s*");       // select authors 
		ArrayList<String> auts = new ArrayList<>(Arrays.asList(au));
		int pg = 0;                                      // find count pages
		if(token[2].matches("[+-]?\\d+")) pg = Integer.parseInt(token[2]);
		String[] tp =  token[3].split("\\s*:\\s*");      // select types   
		TreeSet<String> tps = new TreeSet<>(Arrays.asList(tp));
		return new Book(auts,token[1],pg,tps,token[4]);
	}

	private static String[] libraryStr(){
		String[] informS =
				{" Buchman S. : Heydemark W. , 1977! , 140,  history: biography , Abatis Publishers",
						"Buchman S. , 200 Years of German Humor , 107, history  , Schadenfreude Press ",
						"Kells C. , Ask Your System Administrator , 1226, computer: dataBase , Core Dump Books",
						"Hull H. : Hull K. , But I Did It Unconsciously , 510  , psychology  , Abatis Publishers",
						"Heydemark W. , How About Never? , 473,  biography , Abatis Publishers",
						"Heydemark W. : Hull K. , I Blame My Mother , 333, biography  , Schadenfreude Press",
						"Kellsey , Just Wait Until After School , 86,  children : fantasy , Abatis Publishers",
						"Kellsey , Kiss My Boo-Boo , 55,  children , Abatis Publishers",
						"Heydemark W. , Not Without My Faberge Egg , 523,  history: biography , Abatis Publishers",
						"Kellsey : Hull H. : Hull K. , Perhaps It's a Glandular Problem , 826  , psychology  , Abatis Publishers",
						"Heydemark W. , Spontaneous Not Annoying , 507 ,  biography , Abatis Publishers",
						"Buchman S. , What Are The Civilian Applications? , 802, history : fantasy  , Schadenfreude Press"
				};
		return informS;
	}
}
