package javase.reflect;

import java.util.Random;

/**
 * 类加载： 
 * 1.相对于使用forName("xxx")方式获得对Class对象的引用，更推荐使用xxx.class的方式（不用try块、效率也更高）；
 * 2.类的加载步骤： 
	 * 2.1. 加载：有类加载器执行，会查找字节码，并通过这些字节码创建Class对象； 
	 * 2.2. 链接：验证类中的字节码，为静态域分配存储空间； 
	 * 2.3. 初始化：如果类存在父类，则对其父类进行初始化，然后执行静态初始化器和静态代码块。（初始化被延迟到对静态方法或者非静态域进行首次引用时才执行）
 * 
 * @author Vincent
 *
 */
class Initable1 {
	/**
	 * static final 的值属于“编译期常量”，不需要初始化就可以使用
	 * */
	static final int staticFinal1 = 47;
	/**
	 * staticFinal2并不是编译器常量，访问staticFinal2时会强制初始化Initable1类
	 * */
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initializing Initable1...");
	}

}

class Initable2 {
	/**
	 * 如果static并没有使用final，那么访问staticNonFinal之前，需要先进性连接（为这个域分配空间）和初始化（初始化存储空间）
	 * */
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2...");
	}
}

class Initable3 {
	static int staticNonFinal = 47;
	static {
		System.out.println("Initializing Initable3...");
	}
}

public class ClassInitialization {
	public static Random rand = new Random(47);

	public static void main(String[] args) {
		/**
		 * 1.仅使用.class语法来获得对类的引用不会引发初始化
		 * */
		Class<Initable1> initable1 = Initable1.class;
		System.out.println(Initable1.staticFinal1);// 47
		System.out.println(Initable1.staticFinal2);// 随机数
		System.out.println(Initable2.staticNonFinal);// 147
		try {
			/**
			 * 2.使用Class.forName("xxx")产生的Class引用会立即进行初始化
			 * */
			Class<?> initable3 = Class.forName("javase.reflect.Initable3");
			System.out.println(Initable3.staticNonFinal);// 47
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
