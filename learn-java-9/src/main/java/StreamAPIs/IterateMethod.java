package StreamAPIs;

import java.util.stream.Stream;

public class IterateMethod {
    public static void main(String[] args) {

        /*
         * With java 1.8, there was no way to iterate over stream of object on some condition
         * Using iterate method we have to use limit method to limit number of iteration,
         * otherwise there may be possibility of Infinite loop.
         */
        Stream.iterate(5, x -> x + 5).limit(20).forEach(System.out::println);
        /*
         * But with Java 1.9, you can also put predicate to stop processing.
         */
        Stream.iterate(5, x -> x < 50, x -> x + 5).forEach(System.out::println);
    }
}
