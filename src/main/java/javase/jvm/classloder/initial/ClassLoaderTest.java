package javase.jvm.classloder.initial;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/29
 **/
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException();
                }
            }
        };

        Object obj = myLoader.loadClass("javase.jvm.classloder.initial.ClassLoaderTest");
        Object obj1=ClassLoaderTest.class;
        Object obj2=Class.forName("javase.jvm.classloder.initial.ClassLoaderTest");
        ClassLoaderTest obj3=new ClassLoaderTest();
        System.out.println(obj.getClass());
        System.out.println(obj1.getClass());
        //结果为false，表明被加载到虚拟机中的Class对象不是同一个
        System.out.println(obj==obj1);
        System.out.println(obj2==obj1);
        System.out.println(obj2==obj3.getClass());
    }
}
