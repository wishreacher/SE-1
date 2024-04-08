package lambda;
import java.util.Arrays;

public class MainLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(".........Testing IntStream .....");
		int[] ai = {5, 7, 10 , 13, 20, 12 , 67};
		System.out.println("sumOdd = " + StreamHome.sumOdd(Arrays.stream(ai),13));
		// 22
		System.out.println("maxPrime = " + StreamHome.maxPrime(Arrays.stream(ai),12));
		// OptionalInt[67]
		System.out.println("maxPrime = " + StreamHome.maxPrime(Arrays.stream(ai),72));
		// OptionalInt.empty
		System.out.println(".......Testing Stream<String> .....");
		String st = "  bcv 5a_bc6-abbb+cbaav j,k abnm ";
		System.out.println("------------allIdens - begin");
		StreamHome.allIdens(st).forEach(System.out::println);
		// bcv a_bc6 abbb cbaav j k abnm
		System.out.println("------------allIdens - end");
		String file1 = "src\\lambda\\Book.java";
		String file2 = "src\\testfile.txt";
		System.out.println("minIden--file <"+ file1 + ">  = " + StreamHome.minIden(file1));
		// minIden--file <src\lambda\Book.java>  = Optional[Abatis]
		System.out.println("minIden--file <"+ file2 + ">  = " + StreamHome.minIden(file2));
		// minIden--file <src\simple_file.txt>  = Optional[a]
		System.out.println("cntDistIden--file <"+ file1 + ">  = " + StreamHome.cntDistIden(file1));
		// cntDistIden--file <src\lambda\Book.java>  = 131
		System.out.println("cntDistIden--file <"+ file2 + ">  = " + StreamHome.cntDistIden(file2));
		// cntDistIden--file <src\simple_file.txt>  = 15
		System.out.println(".......Testing Stream<Book> .....");
		System.out.println("" + Arrays.toString(StreamHome.allTypesAuthor(Book.library(), "Buchman S.")));
		// [biography, fantasy, history]
		System.out.println("" + StreamHome.cntAuthor(Book.library(), "psychology"));
		// 3
		System.out.println("maxPagesBook = " + StreamHome.maxPagesBook(Book.library(), "Buchman S.", "Schadenfreude Press"));
		// maxPagesBook = OptionalInt[802]
		System.out.println("maxPagesBook = " + StreamHome.maxPagesBook(Book.library(), "Kellsey", "Schadenfreude Press"));
		// maxPagesBook = OptionalInt.empty
	}

}
