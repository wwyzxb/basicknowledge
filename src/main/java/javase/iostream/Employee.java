package javase.iostream;
import java.io.Serializable;

public class Employee  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private transient String name;
	private static int age=23;
	private int salary;
	
	
	public Employee(String name,int age,int salary){
		this.name=name;
		Employee.age=age;
		this.salary=salary;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static int getAge() {
		return age;
	}


	public static void setAge(int age) {
		Employee.age = age;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}
	



}
