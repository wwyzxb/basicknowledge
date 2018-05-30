package javase.jvm.classloder.blog;

import java.util.List;

/**
 * 测试类
 *
 * @author Administrator
 */
public class ClassLoaderTest {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        //输出ClassLoaderText的类加载器名称
        System.out.println("ClassLoaderText类的加载器的名称:" + ClassLoaderTest.class.getClassLoader().getClass().getName());
        System.out.println("System类的加载器的名称:" + System.class.getClassLoader());
        System.out.println("List类的加载器的名称:" + List.class.getClassLoader());

        ClassLoader cl = ClassLoaderTest.class.getClassLoader();
        while (cl != null) {
            System.out.print(cl.getClass().getName() + "->");
            cl = cl.getParent();
        }
        System.out.println(cl);
    }

}
