package javase.object;

/**
 * @Author Vincent
 * @Date 2017/11/4 19:12
 */
class Creature {
    public Creature() {
        System.out.println("这是Creature类中一个无参数构造器");
    }
}

class Animal extends Creature {
    public Animal(String name) {
        System.out.println("这是Animal类中带有一个参数的构造器，这个动物的name为：" + name);
    }

    public Animal(String name, int age) {
        this(name);
        System.out.println("这是Animal类中带有两个参数的构造器，这个动物的age为：" + age);
    }
}

class Wolf extends Animal {
    public Wolf() {
        super("土狼", 3);
        System.out.println("这是Wolf类中的无参数构造器");
    }
}
//这是Creature类中一个无参数构造器
//        这是Animal类中带有一个参数的构造器，这个动物的name为：土狼
//        这是Animal类中带有两个参数的构造器，这个动物的age为：3
//        这是Wolf类中的无参数构造器

public class ConstructorInitialization {
    public static void main(String[] args) {
        new Wolf();
    }
}
