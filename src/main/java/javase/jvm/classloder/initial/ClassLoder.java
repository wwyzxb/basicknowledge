package javase.jvm.classloder.initial;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/28
 **/
public class ClassLoder {
    /**4.虚拟机启动的时候会先初始化主类,即下面的语句会先执行*/
    static {
        System.out.println("I am the main class...");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        /**1.遇到new、getstatic、putstatic、invokestatic这4条指令时会进行初始化*/
//        InitialClass initialClass=new InitialClass();//new
//        System.out.println(InitialClass.b);//getstatic
//        System.out.println(InitialClass.b=2);//putstatic
//        System.out.println(InitialClass.a);//注意：被static final修饰的变量不会被初始化
//        System.out.println(InitialClass.c);//注意：即使被定义成static final，但要在运行时才能读取值的不会引起初始化
        /**2.做反射调用的时候会引起初始化操作*/
//        Class.forName("javase.jvm.classloder.InitialClass");
        /**3.初始化一个类是会先初始化先触发其父类的初始化*/
        Sub sub=new Sub();

//        Proxy proxy=


    }

}

class InitialClass {
    static {
        System.out.println("InitialClass is initialling...");
    }

    public static final int a = 1;
    public static int b = 1;
    public static final int c = returnVal();

    public static void test() {
        System.out.println("invoke method:test()...");
    }

    public static int returnVal() {
        return 666;
    }
}

class Parent{
    static {
        System.out.println("I am parent class...");
    }
}

class Sub extends Parent{
    static {
        System.out.println("I am sub class...");
    }   }
