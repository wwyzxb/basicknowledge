package javase.object;

/**
 * @Author Vincent
 * @Date 2017/11/4 16:56
 */
public class Initialization {
    /**
     * 这里的w1、w2、w3都是类的成员变量，会在方法和构造器之前按顺序进行初始化
     */
    Window w1 = new Window(1);

    public Initialization() {
        System.out.println("Initialization()");
        Window w33 = new Window(33);
    }

    Window w2 = new Window(2);
    Window w3 = new Window(3);

    /**
     * 静态代码块会首先进行初始化
     */
    static {
        System.out.println("static...");
    }

    /**
     * 代码块在成员变量之后进行初始化
     */ {
        System.out.println("test");
    }

    Window w5 = new Window(5);

    /**
     * 静态成员的初始化按顺序执行
     */
    static Window w4 = new Window(4);//只需进行一次初始化

    void print() {
        System.out.println("print function...");
    }

//    static...
//    Window(4)
//    Window(1)
//    Window(2)
//    Window(3)
//    test
//    Initialization()
//    Window(33)
//    print function...
    public static void main(String[] args) {
        Initialization initialization = new Initialization();
        initialization.print();
    }
}

class Window {
    public Window(int i) {
        System.out.println("Window(" + i + ")");
    }
}
