import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ExamplesJava8String {

	public static void main(String[] args) {

		String str = "aaaabbbbccc";
		StringBuilder sb = new StringBuilder(str.length());
		str.chars().distinct().mapToObj(ch -> (char) ch).forEach((ch) -> sb.append(ch));
		sb.toString();

		System.out.println(sb + "\n");
		
		String str2 = "cc";

		List<String> list = Arrays.asList("aaa", "beatawarso@o2.pl", "aaa", "bb", "aa", "bb", "aba");
		list.stream()
		.distinct()
		.skip(1)
		.filter(n -> n.length() > 2)
		.filter(n -> n.endsWith("a"))
		.filter(n -> n.startsWith("b"))
		.filter(n -> n.contains("a"))
		.filter(n -> n.equals(str2))
		.filter(n -> n.matches(
		"^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"))
		.sorted()
		.sorted(Comparator.reverseOrder())
		.forEach(System.out::println);

		long l = list.stream().distinct().count();
		System.out.println("Unique elements: " + l);

		String[] array = new String[] { "Marek", "Karol", "Michał" };
		Stream<String> stream = Arrays.stream(array);
		stream.forEach(System.out::println);

	}

}

/*
 * Miniprogramik, pokazujący kilka ciekawych funkcji Javy 8, czyli jak w prosty
 * sposób wykonać podstawowe operacje na Stringach np: 
 * 1. Usunąć duplikaty ze stringa 
 * 2. Usunąć duplikaty z listy 
 * 3. opuścić pierwsze np 2 elementy na liście 
 * 4. Wybrać dłuższe/krótsze niż>2 etc. 
 * 5. Kończące się/zaczynające się na wybraną literę 
 * 6. Zawierające literę np a 
 * 7. Porównanie z innym stringiem
 * 8. Sprawdzenie czy jest to adres email za pomoca regexa 
 * 9. Sortowanie od a-z albo odwrotnie 
 * 10. Zliczanie elementów unikalnych na liście 
 * 11. Zamiana tablicy na strumień i wyciagniecie z niego danych
 * 
 * 
 */
