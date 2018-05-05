package test;

/**
 * @Author: wuxiaobing
 * @Date 2018/1/25
 **/
class Test{
    public static final int staticNum=10;
    public static int num=10;
    public final static int funNum=val();

    public static int val(){
        return 100;
    }

    static {
        System.out.println("static code block");
    }

    public Test() {
        System.out.println("test constructor...");
    }
}

public class TestInitial {
    public static void main(String[] args) throws ClassNotFoundException {
//        System.out.println(SolutionTest.staticNum);
//        System.out.println(SolutionTest.funNum);
//        SolutionTest test=new SolutionTest();
//        Class clazz=SolutionTest.class;
        Class clazz=Class.forName("test.Test");

    }
}
