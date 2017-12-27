package javase.jvm.classloder;

/**
 * 类加载--字段解析
 * @Author Vincent
 * @Date 2017/12/27 23:36
 */
public class FieldResolution {
    interface Interface0{
        int A=0;
    }
    interface Interface1 extends Interface0{
        int A=1;
    }
    interface Interface2{
        int A=2;
    }

    static class Parent implements Interface1{
        public static int A=3;
    }

    static class Sub extends Parent implements Interface2{
        public static int A=4;
    }

    public static void main(String[] args){
        System.out.println(Sub.A);//对字段Sub.A进行解析
    }
}
