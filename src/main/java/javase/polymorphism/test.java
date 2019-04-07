package javase.polymorphism;

public class test {
	public static void testAnimalVocie(Animal a) {
		a.Vocie();
	}
	public static void main(String[] args) {
//		Animal a=new Animal();
//		Animal c=new Cat();
//		Animal d=new Dog();
//		Animal t=new Tiger();
//		
//		testAnimalVocie(a);
//		testAnimalVocie(c);
//		testAnimalVocie(d);
//		testAnimalVocie(t);
//		
//		Cat cat=(Cat)c;
//		cat.catchMouse();
		
		try {
			Class<?> test=Class.forName("test.polymorphism.Cat");
			Animal animal=(Animal)test.newInstance();
			animal.Vocie();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Animal a=new Cat();
		Animal a1=(Animal) a;
		a1.Vocie();
		
	}

}
