package javase.jvm.classloder;

/**
 * @Author Vincent
 * @Date 2017/12/27 23:52
 */
public class ClassMethodResolution {
    static {
        i=0;

    }
    static int i=1;


    public static void main(String[] args){
        new Sub().test1();
    }
}
interface Interface0{
    void test1();
}
abstract class Parent implements Interface0{
    static void test(){

    }
}
class Sub extends Parent{
    static void test(){

    }

    @Override
    public void test1() {

    }
}
