package StreamAPIs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMethod {
    public static void main(String[] args) {

        /* Now filter even number from this Collection */
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            number.add(i);
        }

        /* With Java 1.7 */
        List<Integer> evenNumbersList = new ArrayList<>();
        for (Integer i : number){
            if(i%2 == 0 ){ evenNumbersList.add(i);}
        }
        System.out.println("Java 1.7 -> " + evenNumbersList);

        /* With Java 1.8 */
        List<Integer> evenNumbersList2 = number.stream().filter(i -> i%2==0).collect(Collectors.toList());
        System.out.println("Java 1.8 -> " + evenNumbersList2);

    }
}
