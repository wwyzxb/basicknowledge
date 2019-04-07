package javase.polymorphism;

public class Animal {
	public void Vocie(){
		System.out.println("��ͨ����Ľ���");
	}
}
class Cat extends Animal{
	public void Vocie() {
		
		System.out.println("������");
	}
	public void catchMouse() {
		System.out.println("èץ����");
	}
}
class Dog extends Animal{
	public void Vocie() {
		System.out.println("������");
	}
}
class Pig extends Animal{
	public void Vocie() {
		System.out.println("�ߺߺ�");
	}
}
class Tiger extends Animal{
	public void Vocie() {
		System.out.println("����");
	}
}

