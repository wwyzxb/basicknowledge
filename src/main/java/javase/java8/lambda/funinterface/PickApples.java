package javase.java8.lambda.funinterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: wuxiaobing
 * @Date 2018/1/20
 **/
class AppleComparator implements Comparator<Apple> {

    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }
}

public class PickApples {
    private final static List<Apple> inventory;

    static {
        inventory = Arrays.asList(new Apple("green", 160), new Apple("red", 140), new Apple("green", 150), new Apple("red", 149));
    }

    /**
     * 代码传递
     */
    @Test
    public void testSortInventory1() {
        inventory.sort(new AppleComparator());
    }

    /**
     * 匿名类
     */
    @Test
    public void testSortInventory2() {
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
    }

    /**
     * Lambda
     */
    @Test
    public void testSortInventory3() {
        inventory.sort((Apple o1, Apple o2) -> o1.getWeight().compareTo(o2.getWeight()));
    }

    /**
     * 方法引用
     */
    @Test
    public void testSortInventory4() {
        inventory.sort(Comparator.comparing(Apple::getWeight));
        //或者
        inventory.sort(Comparator.comparing((Apple a)->a.getWeight()));
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
    private Integer weight;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}
