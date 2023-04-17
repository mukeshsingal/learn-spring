package StreamAPIs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapMethod {
    public static void main(String[] args) {

        /* Now filter even number from this Collection */
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            number.add(i);
        }

        /* Output : Java 1.8 -> [0, 0, 1, 1, 4, 8, 9, 27, 16, 64, 25, 125, 36, 216, 49, 343, 64, 512, 81, 729, 100, 1000] */

        /*Get list of Square and cubes of odd numbers from list */
        List<Integer> onlyCubeAndSquareOfEvenNumbers = number.stream().flatMap(i ->{
            if(i % 2 ==0 ){
                return Stream.empty();
            }
            else{
                return Stream.of(i*i, i*i*i);
            }
        }).collect(Collectors.toList());
        System.out.println("Java 1.8 -> " + onlyCubeAndSquareOfEvenNumbers);

        /* output : Java 1.8 -> [1, 1, 9, 27, 25, 125, 49, 343, 81, 729] */
    }
}
