package javase.java8.lambda.funinterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: wuxiaobing
 * @Date 2018/1/20
 **/
public class PickApples {
    static List<Apple> inventory;

    static {
        inventory = Arrays.asList(
                new Apple("green", 160),
                new Apple("red", 160),
                new Apple("green", 150),
                new Apple("red", 150));

    }

    public List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 将方法作为参数进行传递
     */
    @Test
    public void testFilterApples() {
        List<Apple> result = filterApples(inventory, Apple::isGreenApple);
        result = filterApples(result, Apple::isHeavyApple);
        System.out.println(result);
    }

    /**
     * 使用Lambda来代替只会使用到一次的方法
     */
    @Test
    public void testFilterApplesWithLambda() {
        List<Apple> result = filterApples(inventory, (Apple a) -> a.getWeight() > 150 && "red".equals(a.getColor()));
        System.out.println(result);
    }
}

@Data
@AllArgsConstructor
class Apple {
    private String color;
    private int weight;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}
