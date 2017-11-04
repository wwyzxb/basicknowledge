package javase.object;

/**
 * Java的值传递
 *
 * @Author Vincent
 * @Date 2017/11/4 14:43
 */
public class ValueSwap {
    int a;
    int b;

    public static void swap(ValueSwap vs) {
        int tmp = vs.a;
        vs.a = vs.b;
        vs.b = tmp;
        //swap-->:a=222,b=111
        System.out.println("swap-->:a=" + vs.a + ",b=" + vs.b);
    }

    public static void main(String[] args) {
        ValueSwap test = new ValueSwap();
        test.a = 111;
        test.b = 222;
        swap(test);
        //main-->:a=222,b=111
        System.out.println("main-->:a=" + test.a + ",b=" + test.b);
    }
}
