package SafeVarArgs;

import java.util.Arrays;
import java.util.List;

public class SafeVarargsCase {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("Mukesh", "Singal");
        List<String> l2 = Arrays.asList("Mohit", "Mishra");
        join(l1, l2);
    }
    /*
     * When we are sure about there will no Heap pollution in that case to Suppress Compiler warning
     * we can use SafeVarargs annotations
     */
    @SafeVarargs
    public static void join(List<String>... lists) {
        for(List<String> list : lists){
            System.out.println(list.toString());
        }
    }
}
