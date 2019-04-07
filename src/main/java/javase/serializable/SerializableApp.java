package javase.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableApp {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File file=new File("/files");//1������file����Դͷ
		
		//���л�����
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));//2��ѡ���ʵ�����
		Person p1=Person.getSingleInstance();
		oos.writeObject(p1);//3��д�����ļ������л���������
		oos.close();//4���ر���
		
		//�����л�����
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));//2��ѡ���ʵ�����
		Person p2=(Person) ois.readObject();//3�����ļ��������л�
		ois.close();//4���ر���
		System.out.println(p2.toString());
		System.out.println(p1==p2);
	}

}
