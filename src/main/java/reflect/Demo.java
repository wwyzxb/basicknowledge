package reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取Class对象的4种方法
 *
 * @Author: wuxiaobing
 * @Date 2017/12/25
 **/
@Slf4j
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        //1.运用T.class 语法(T是任意的Java类型)
        Class clazz1 = ClassType.class;
        //2.调用getClass()（Object类中的getClass()方法返回一个Class类型的实例）
        ClassType obj = new ClassType();
        Class clazz2 = obj.getClass();
        //3.运用static method Class.forName()
        Class clazz3 = Class.forName("reflect.ClassType");
        //4.运用primitive wrapper classes的TYPE 语法（针对基本数据类型）
        Class clazz4 = Integer.TYPE;
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        //5.返回类名
        System.out.println(clazz1.getName());
        //6.创建一个类实例，会调用默认构造器
        System.out.println(clazz1.newInstance());
        //7.返回类的超类名称
        System.out.println(clazz1.getSuperclass());

        //8.返回public域的字段
        Field[] fields = clazz1.getFields();
        log.info("获得public域的字段：");
        for (Field field : fields) {
            System.out.println(field.getName() + " ");
            //8.1获得字段的参数类型
            System.out.println(field.getType() + " ");
        }
        //9.返回所有的字段
        Field[] fields1 = clazz1.getDeclaredFields();
        log.info("获得所有的字段：");
        for (Field field : fields1) {
            System.out.println(field.getName() + " ");
        }

        //10.返回所有的public域的方法（包括从父类继承的方法）
        Method[] methods = clazz1.getMethods();
        log.info("获得public方法：");
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getParameterTypes());
        }

        //11.获得私有的方法
        Method methods1 = clazz1.getDeclaredMethod("privateMethod1", null);
        log.info("获得所有定义的方法：");
        System.out.println(methods1.getName());

        //12.获得私有构造器
        Constructor constructor = clazz1.getDeclaredConstructor(new Class[]{String.class, String.class, String.class, String.class});
        System.out.println(constructor);

        System.out.println(ClassType.class.isInstance(new ClassType()));




    }
}