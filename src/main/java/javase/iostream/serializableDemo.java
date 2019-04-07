package javase.iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class serializableDemo {
	// ���л�
	public static void serialize(String path) throws Exception {
		Employee emp = new Employee("Vincent", 25, 100000);
		int[] arr = { 1, 2, 3, 4, 5, 6 };//�������ֱ�����л�
		// 1������Դ
		File file = new File(path);
		// 2��ѡ������ObjectOutputStream
		ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)));
		oos.writeObject(emp);
		oos.writeObject(arr);
		;
		if (oos != null)
			oos.close();
	}

	// �����л�
	public static void deserialization(String path)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		// ����Դ
		File file = new File(path);
		// ѡ������ObjectInputStream
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(file)));
		// ������ȡ��˳����д��һ�£�������ڲ��ܶ�ȡ
		Object obj = ois.readObject();
		// ���ж��Ƿ�����һ��
		if (obj instanceof Employee) {
			Employee emp = (Employee) obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
		}

		Object object = ois.readObject();
		int[] arr = (int[]) object;
		System.out.println(Arrays.toString(arr));
		ois.close();

	}

	public static void main(String[] args) throws Exception {
		serialize("files/seri/seri.txt");
		deserialization("files/seri/seri.txt");

	}

}
