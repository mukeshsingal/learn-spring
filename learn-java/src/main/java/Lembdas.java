public class Lembdas {
    public static void main(String[] args) {


        /**
         * Custom Functional Interface with only one method.
         */
        Calculate addition = (a, b) -> a + b;
        Calculate difference = (a, b) -> Math.abs(a - b);

        System.out.println(addition.calculate(10, 10));
        System.out.println(difference.calculate(10, 10));

    }
}
