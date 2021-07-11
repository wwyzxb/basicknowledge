package javase.classinfo.reflect;

import java.lang.reflect.*;
import java.util.regex.*;

// {Args: javase.classinfo.reflect.ShowMethods}
public class ShowMethods {
    private static String usage = "usage:\n" + "ShowMethods qualified.class.name\n" + "To show all methods in class or:\n" + "ShowMethods qualified.class.name word\n" + "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");

    private void privateSay() {

    }

    void defaultSay() {

    }

    static class InnerClass {
    }

    private void privateMeth() {

    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getDeclaredMethods();//获得类中所有的方法
            Constructor[] ctors = c.getConstructors();//获得类中所有的构造器
            if (args.length == 1) {
                System.out.println("**************方法start*****************");
                for (Method method : methods) {
                    method.setAccessible(true);
                    System.out.println(method.toString());
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                }
                System.out.println("**************方法end*****************");

                System.out.println("**************构造器start*****************");
                for (Constructor ctor : ctors) {
                    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                }
                System.out.println("**************构造器end*****************");

                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods)
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                for (Constructor ctor : ctors)
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
} /* Output:
public static void main(String[])
public native int hashCode()
public final native Class getClass()
public final void wait(long,int) throws InterruptedException
public final void wait() throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public final native void notify()
public final native void notifyAll()
public ShowMethods()
*///:~
