package lambda;

import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class StreamHome {
	public static int sumOdd(IntStream is, int m){
		// ... statements
		return is.filter(n -> n > 0 && n <= m && n % 2 == 0)
				.sum();
	}
	//------------------------------------------------------------------------------------------------
	public static OptionalInt maxPrime(IntStream is, int n){
		// ... statements
		return is.filter(num -> num > n && isPrime(num))
				.max();
	}
	// .... methods
	private static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
	//------------------------------------------------------------------------------------------------
	public static Stream<String> allIdens(String word){
		// ... statements
		ArrayList<String> idens = new ArrayList<>();
		Pattern idenPattern = Pattern.compile("[a-zA-Z][a-zA-Z_0-9]*");
		Matcher matcher = idenPattern.matcher(word);
		while (matcher.find()) {
			idens.add(matcher.group());
		}
		return idens.stream();
	}
	//------------------------------------------------------------------------------------------------
	public static Optional<String> minIden(String file){
		try (Stream<String> lines = Files.lines(Paths.get(file))) {
			// ... statements
			Pattern idenPattern = Pattern.compile("[a-zA-Z][a-zA-Z_0-9]*");
			return lines.flatMap(StreamHome::allIdens)
					.min(String::compareTo);
			//.min(Comparator.comparing(String::toString));
		} catch(Exception ex){
			System.out.println("minIden: " + ex.getMessage()); return Optional.empty();
		}
	}
	//------------------------------------------------------------------------------------------------
	public static long cntDistIden(String file){
		try (Stream<String> lines = Files.lines(Paths.get(file))) {
			// ... statements
			Pattern idenPattern = Pattern.compile("[a-zA-Z][a-zA-Z_0-9]*");
			Set<String> idens = new HashSet<>();
			lines.forEach(line -> {
				int commentIndex = line.indexOf("//");
				String code = (commentIndex >= 0) ? line.substring(0, commentIndex) : line;
				Matcher matcher = idenPattern.matcher(code);
				while (matcher.find()) {
					idens.add(matcher.group());
				}
			});
			return idens.size();
		} catch(Exception ex){
			System.out.println("cntDistIden: " + ex.getMessage()); return 0;
		}
	}
	//------------------------------------------------------------------------------------------------
	// список всіх різних жанрів книг автора aut, що представлені в бібліотеці library
	public static String[] allTypesAuthor(Stream<Book> library, String aut) {
		// ... statements
		return library
				.filter(book -> book.getAuthors().contains(aut))
				.flatMap(book -> book.getTypes().stream())
				.distinct()
				.sorted()
				.toArray(String[]::new);
	}
	//------------------------------------------------------------------------------------------------
	// скільки різних авторів мають книги в жанрі type
	public static long cntAuthor(Stream<Book> library, String type) {
		// ... statements
		return library
				.filter(book -> book.getTypes().contains(type))
				.flatMap(book -> book.getAuthors().stream())
				.distinct()
				.count();
	}
	//------------------------------------------------------------------------------------------------
	// товщина найтовщої книги автора aut виданої видавництвом pub, що є в бібліотеці library
	public static OptionalInt maxPagesBook(Stream<Book> library, String aut, String pub) {
		// ... statements
		return library.filter(book -> book.getAuthors().contains(aut) && book.getPubName().equals(pub))
				.mapToInt(Book::getPages)
				.max();
	}
}
