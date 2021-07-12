package javase.classinfo.reflect.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/25
 **/
public class ClassDemo {

    public String publicVal1;
    public String publicVal2;
    private String privateVal1;
    private String privateVal2;
    private List<String> list1;
    private List<Integer> list12;

    public ClassDemo() {

    }

    public ClassDemo(String val1, String val2, String val3) {
        this.publicVal1 = val1;
        this.publicVal2 = val2;
        this.privateVal1 = val3;
    }

    private ClassDemo(String val1, String val2, String val3, String val4) {
        this(val1, val2, val3);
        this.privateVal2 = val4;
    }

    public void publicMethod1() {

    }

    public void publicMethod2() {

    }

    private void privateMethod1() {

    }

    private void privateMethod2() {

    }

    public static void main(String[] args) {
        Class clazz = ClassDemo.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getGenericType() instanceof ParameterizedType) {
                System.out.println(field.toString());
                System.out.println(((ParameterizedType) field.getGenericType()).getRawType().getTypeName());
            }
        }

    }

}
