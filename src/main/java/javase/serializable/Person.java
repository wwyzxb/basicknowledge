package javase.serializable;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5311867842617925898L;
	private String name = null;
	private Integer age = null;
	private String gender = null;
	
	private static Person person=null;
	
	private Person() {
		System.out.println("�޲ι�����");
	}

	private Person(String name, int age, String gender) {
		System.out.println("�������Ĺ�����");
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public static Person getSingleInstance(){
		if(person==null){
			person=new Person("Lucy", 24, "Ů");
		}
		return person;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return name + "," + age + "," + gender;
	}
	
	/**
	 * ������ʵ��Serializable�ӿڣ�����Externalizable�ӿڣ�����I/O���ж�ȡ����ʱ��readResolve()�������ᱻ���õ���
	 * ʵ���Ͼ�����readResolve()�з��صĶ���ֱ���滻�ڷ����л������д����Ķ���
	 * @return
	 * @throws ObjectStreamException
	 */
	private Object readResolve() throws ObjectStreamException{
		return Person.person;
	}

}
