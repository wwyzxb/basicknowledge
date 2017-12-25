package javase.classinfo.reflect.type;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/25
 **/
public class ReflectUtil {
    /**
     * 获取某个对象的属性
     */
    public Object getProperty(Object owner, String fieldName) throws Exception {
        //1、得到该对象的Class。
        Class<?> ownerClass = owner.getClass();
        //2、通过Class得到类声明的属性。
        Field field = ownerClass.getField(fieldName);
        //3、通过对象得到该属性的实例，如果这个属性是私有的，这里就会抛出IllegalAccessException。
        Object property = field.get(owner); //此处获取的是对象的属性，所以传递的是owner。
        return property;
    }

    /**
     * 获取某个类的静态属性
     */
    public Object getStaticProperty(String className, String fieldName) throws Exception {
        //1、得到该类的Class。
        Class<?> ownerClass = Class.forName(className);
        //2、通过Class得到类声明的属性。
        Field field = ownerClass.getField(fieldName);
        //3、由于获取的是静态属性，此处传递的为Class，直接从Class中获取静态属性。
        Object property = field.get(ownerClass);
        return property;
    }

    /**
     * 执行某对象的方法
     */
    public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
        //1、获取对象的Class。
        Class<?> ownerClass = owner.getClass();
        //2、组装参数的Class数组，用于匹配Method的条件
        Class<?>[] argsClass = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            argsClass[i] = args[i].getClass();
        }
        //3、通过Method名和参数的Class数组得到要执行的Method
        Method method = ownerClass.getMethod(methodName, argsClass);
        //4、调用invoke执行Method.由于执行的是对象的方法，此处传递的为owner。
        return method.invoke(owner, args);
    }

    /**
     * 执行类的静态方法
     */
    public Object invokeStaticMethod(String className, String methodName, Object[] args) throws Exception {
        //1、获取类的Class。
        Class<?> ownerClass = Class.forName(className);
        //2、组装参数的Class数组，用于匹配Method的条件
        Class<?>[] argsClass = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            argsClass[i] = args[i].getClass();
        }
        //3、通过Method名和参数的Class数组得到要执行的Method
        Method method = ownerClass.getMethod(methodName, argsClass);
        //4、调用invoke执行Method.由于执行的是类的静态方法，不需要借助对象实例，此处传递的为null。
        return method.invoke(null, args);
    }

    /**
     * 新建实例。调用带参构造函数。
     */
    public Object newInstance(String className, Object[] args) throws Exception {
        //1、获取要构造实例的Class
        Class<?> newOneClass = Class.forName(className);
        //2、得到参数的Class数组
        Class<?>[] argsClass = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            argsClass[i] = args[i].getClass();
        }
        //3、得到构造器
        Constructor<?> ctor = newOneClass.getConstructor(argsClass);
        //4、新建实例
        return ctor.newInstance(args);
    }

    /**
     * 判断是否为某个类的实例
     */
    public boolean isInstance(Object obj, Class<?> clazz) {
        return clazz.isInstance(obj);
    }

    /**
     * 得到数组中的某个元素
     */
    public Object getByArray(Object array, int index) {
        return Array.get(array, index);
    }
}
