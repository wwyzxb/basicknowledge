package javase.classinfo;

import java.lang.Object;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfoClass(Class<?> cc) {
        /**
         * cc.getName():会输出包含包信息的类名
         * cc.getCanonicalName()：会输出包含包信息的类名
         * cc.isInterface():判断当前类是否为接口
         * cc.getSimpleName()：会删除简单的类名信息
         * */
        System.out.println("Class name:" + cc.getName() + " is interface?-->"
                + cc.isInterface());
        System.out.println("Simple name:" + cc.getSimpleName());
        System.out.println("Canonical name:" + cc.getCanonicalName());
        System.out.println("**********我是华丽的分隔符**********");

    }

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            /**
             * Class.forName("xxx"):获得类名为xxx的类的Class对象
             * */
            c = Class.forName("javase.classinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        printInfoClass(c);
        /**
         * c.getInterfaces():获得Class对象实现的接口的接口信息
         * */
        for (Class<?> face : c.getInterfaces()) {
            printInfoClass(face);
        }
        /**
         * c.getSuperclass():获得Class对象的直接父类
         * */
        Class<?> up = c.getSuperclass();
        Object obj = null;
        try {
            /**
             * up.newInstance():创建具体的实例
             * 注意：使用newInstance()创建实例的类必须要包含默认的构造器。
             * */
            obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }
        printInfoClass(obj.getClass());
    }

}
