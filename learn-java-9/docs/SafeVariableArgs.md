# Updates in SafeVarargs Annotations

Until `Java 1.8` `@SafeVarargs` annotation was only application for Constructors, static or final methods but from `Java 1.9` you can also apply it to private methods also which may not be static or final.

Read below documentation to get idea about concepts.

### Variable Arguments Annotations 

> Variable Arguments was introduced in `Java 1.7`. However it had possibility of getting Heap pollution. With `Java 1.9` heap problem is resolved. 

### Why VarArgs?
Before `Java 1.7`, if you want to use same logic required for variable number of arguments, you have to create function for all combination like below example.
There are some use-cases when you may required to pass variable number of arguments. Now you can use ```...``` operator to pass variable number of arguments.

For eg.  
```java
 public class SafeArgs{
     public static void main(String[] args) {
         System.out.println("Sum of two numbers " + sum(1, 2));
         System.out.println("Sum of three numbers " + sum(1, 2, 3));
     }
 
     public static int sum(int... nums){
         int sum = 0;
         for (int num: nums){
             sum = sum + num;
         }
         return sum;
     }
 }
```

> Internally passed variable will be stored as __Array__ of given type.

### What is Heap Pollution
If at runtime if a variable of one type try to point to object of other type, cause __ClassCastException__, this is called Heap Pollution. 
There are some cases when you can face Heap Pollution like when try to use generics with VarArgs. 

For Eg.
```java
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
```

### SafeVarargs Annotation 
Now when you are sure, there will not be any heap pollution in that case you can use `@SafeVarargs` Annotation to Suppress Compiler warnings.
```java
import java.util.Arrays;
import java.util.List;

public class SafeVarargsCase {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("Mukesh", "Singal");
        List<String> l2 = Arrays.asList("Mohit", "Mishra");
        join(l1, l2);
    }
    
    @SafeVarargs
    public static void join(List<String>... lists) {
        for(List<String> list : lists){
            System.out.println(list.toString());
        }
    }
}

```  

