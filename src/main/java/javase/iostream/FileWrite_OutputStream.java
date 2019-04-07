package javase.iostream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWrite_OutputStream {
	public static void main(String[] args) {
		//1��������ϵ File���� Ŀ�ĵ�
		File file=new File("files/writeDemo.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("�ļ�����ʧ�ܣ�");
			}
		}
		//2��ѡ���� �ļ������  OutputStream  FileOutputStream
		OutputStream os=null;
		try {
			//��׷����ʽд���ļ�
			os=new FileOutputStream(file,true);
			//3������
			String str="hello world!\r\n";
			//�ַ���ת�ֽ�����
			os.write(str.getBytes());
			//ǿ��ˢ��
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("δ�ҵ�ָ���ļ���");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ�д��ʧ�ܣ�");
		}finally{
			if(os!=null)
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("������ر�ʧ�ܣ�");
				}
		}
			
	}

}
