package StreamAPIs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DropWhileMethod {

    public static void main(String[] args) {

        List<Integer> number = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            number.add(i);
        }

        /* Drop while stop processing as soon predicate condition turn to false and return rest of list items */
        List<Integer> newNumberList = number.stream().dropWhile(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println("Drop While -> " + newNumberList);

        /* output : Drop While -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] */
    }
}

