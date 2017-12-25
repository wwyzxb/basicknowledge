package javase.classinfo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Vincent
 * @Date 2017/12/17 15:40
 */
public class UserTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<User> clazz = User.class;
        User user = clazz.newInstance();

        Field field = clazz.getDeclaredField("id");
        field.setAccessible(true);//关闭安全性检查
        field.set(user, "001");//给private属性赋值
        System.out.println(user.getId());

        Method method = clazz.getDeclaredMethod("say", String.class);
//        method.setAccessible(true);//关闭安全性检查
        method.invoke(clazz.newInstance(), "Vincent");//调用private方法
    }
}
