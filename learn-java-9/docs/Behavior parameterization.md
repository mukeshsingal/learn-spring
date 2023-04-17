Behavior parameterization
A well-known problem in software engineering is that no matter what you do, user requirements will change. For example, imagine an application to help a farmer understand his inventory. The farmer might want a functionality to find all green apples in his inventory. But the next day he might tell you, “Actually I also want to find all apples heavier than 150 g.” Two days later, the farmer comes back and adds, “It would be really nice if I could find all apples that are green and heavier than 150 g.” How can you cope with these changing requirements?


Behavior parameterization is a software development pattern that lets you handle frequent requirement changes. In a nutshell, it means taking a block of code and making it available without executing it. This block of code can be called later by other parts of your programs, which means that you can defer the execution of that block of code. For instance, you could pass the block of code as an argument to another method that will execute it later. As a result, the method’s behavior is parameterized based on that block of code.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Farmer {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple("green"),
                new Apple("red"),
                new Apple("green"),
                new Apple("red"));

        List<Apple> greenApples = filterGreenApples(inventory);
        for (Apple apple : greenApples) {
            System.out.println(apple.getColor() + " Apples");
        }
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> greenApples = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                greenApples.add(apple); //Add only green apples
            }
        }
        return greenApples;
    }
}

```
```java
public class Apple {
    String color;

    public Apple(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    public String setColor() {
        return color;
    }
}
```
