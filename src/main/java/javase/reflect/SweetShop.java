package javase.reflect;

class Candy {
	static {
		System.out.println("Loding Candy...");
	}
}

class Gum {
	static {
		System.out.println("Loding Gum...");
	}
}

class Cookies {
	static {
		System.out.println("Loding Cookies...");
	}
}

public class SweetShop {
	public static void main(String[] args) {
		new Candy();
		try {
			
			/**
			 * 1.只要想在运行时使用类型信息，就必须首先获得恰当的Class对象的引用。
			 * 2.Class.forName()就是实现此功能的便捷途径。
			 * */
			//JVM查找并加载指定的类,加载时会执行该类的静态代码块
			Class.forName("javase.reflect.Gum");
		} catch (ClassNotFoundException e) {
			System.err.println("Couldn't find Gum...");
			e.printStackTrace();
		}
		new Cookies();
		
	}

}
