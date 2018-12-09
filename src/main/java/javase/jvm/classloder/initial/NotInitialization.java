package javase.jvm.classloder.initial;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/29
 **/
public class NotInitialization {
    public static void main(String[] args){
        ClassTest[] arr=new ClassTest[10];
        arr[0]=new ClassTest();
        System.out.println(arr[0]);
    }
}

class ClassTest{
    static {
        System.out.println("I am a class udclassloader...");
    }
}
