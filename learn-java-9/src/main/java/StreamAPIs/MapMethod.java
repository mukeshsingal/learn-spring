package StreamAPIs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapMethod {
    public static void main(String[] args) {

        /* Now filter even number from this Collection */
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            number.add(i);
        }

        List<Integer> square = number.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println("Java 1.8 -> " + square);

    }
}
