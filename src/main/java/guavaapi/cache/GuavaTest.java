package guavaapi.cache;

import com.google.common.base.Optional;

public class GuavaTest {
    public static void jdkPlusMethod() {
        Integer a = null;
        Integer b = new Integer(10);
        System.out.println(a + b);
    }

    public static void guavaPlusMethod() {
        Integer invalid = null;
        Optional<Integer> a = Optional.of(invalid);
        Optional<Integer> b = Optional.of(new Integer(10));
        System.out.println(a.get() + b.get());
    }

    static void sayBye() {
        System.out.println("GoodBye...");
    }

    public static void main(String[] args) {
//        jdkPlusMethod();
        guavaPlusMethod();
        sayBye();
    }

}
