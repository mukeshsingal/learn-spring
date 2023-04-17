package SafeVarArgs;

public class SafeArgs {

    private static int sumOfTwo(int num1, int num2) {
        return num1 + num2;
    }

    private static int sumOfThree(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    public static void main(String[] args) {
        /*
         * before 1.7 JDK, if you want to use same logic required for variable number of arguments,
         * you have to create function for all combination like below example.
         */
        System.out.println("Sum of two numbers " + sumOfTwo(1, 2));
        System.out.println("Sum of three numbers " + sumOfThree(1, 2, 3));

        /*
         * Already two sum methods are defined if I have to sum 4 elements I have to define a new function again.
         * Instead lets create a function which will take a variable number of arguments.
         */
        System.out.println("Sum of two numbers " + sum(1, 2));
        System.out.println("Sum of three numbers " + sum(1, 2, 3));

    }

    public static int sum(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        return sum;
    }

}