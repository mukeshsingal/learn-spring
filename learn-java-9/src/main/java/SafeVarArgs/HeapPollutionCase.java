package SafeVarArgs;

import java.util.Arrays;
import java.util.List;

public class HeapPollutionCase {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("Mukesh", "Singal");
        List<String> l2 = Arrays.asList("Mohit", "Mishra");
        join(l1, l2);
    }

    public static void join(List<String>... lists) {
        Object[] listObject = lists;
        listObject[0] = Arrays.asList(10, 20);
        String name = (String) lists[0].get(0); //String type pointing to Integer type
        System.out.println(name);
    }
}
