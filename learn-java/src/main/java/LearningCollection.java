import java.util.*;
import java.util.stream.Collectors;

public class LearningCollection {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Paul", "Mukesh", "Rakesh", "Hareesh");

        /**
         * Without Lembda Expressions
         */
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        /**
         * With Lembda Expression
         */
        Collections.sort(names, (a, b) -> a.compareTo(b));

        Collections.sort(names, Comparator.naturalOrder());
        Collections.sort(names, Comparator.reverseOrder());


        Book b1 = new Book("Magic of thinking Big", "David", 1996);
        Book b2 = new Book("Eat that frog", "Brian Tracy", 2017);
        Book b3 = new Book("Deep work", "Cal Newport", 2010);
        Book b4 = new Book("Before you start up", "Pankaj Goyal", 1993);

        List<Book> books = Arrays.asList(b1, b2, b3, b4);

        int totalYears = books.stream()
                .collect(Collectors.summingInt(Book::getYear));
        System.out.println("Total " + totalYears);



        List<String> authors = books.stream()
                .map(Book::getAuthor)
                .collect(Collectors.toList());

        System.out.println("Authors " + authors.toString());

        Set<Integer> numbers = new HashSet<Integer>(Arrays.asList(4, 3, 2, 1, 1, 1));
        System.out.println(numbers);

    }


}
