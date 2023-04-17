package StreamAPIs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TakeWhileMethod {

    public static void main(String[] args) {

        List<Integer> number = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            number.add(i);
        }

        /* take while stop procesing as soon predicate condition turn to false and return collected items */
        List<Integer> newNumberList = number.stream().takeWhile(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println("Take While -> " + newNumberList);

        /* output : Take While -> [0] */
    }
}

