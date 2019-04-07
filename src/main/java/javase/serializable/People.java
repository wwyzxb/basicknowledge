package javase.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class People implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	
	public People(){
		this.name="Vicent";
		this.age=25;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return this.age;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	
	public static void main(String[] args) {
		People people=new People();
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		try {
			FileOutputStream fos=new FileOutputStream("files\\perple.out");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(people);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		People people2;
		try {
			FileInputStream fis=new FileInputStream("files\\perple.out");
			ois=new ObjectInputStream(fis);
			people2=(People)ois.readObject();
			System.out.println("name:"+people2.getName());
			System.out.println("age:"+people2.getAge());
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
