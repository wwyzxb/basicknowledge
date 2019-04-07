package javase.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileRead_InputStream {
	public static void main(String[] args) {
		//1��������ϵ,file�����Լ�Դͷ
		File file=new File("files\\testIn.txt");
		InputStream is=null;
		try {
			//2��ѡ����,�ļ������� InputStream FileInputStream
		  is=new FileInputStream(file);
		  //3��������ʹ��byte��������ȡ
		  byte[] car=new byte[1024];
		  int len=0;
		  while((len=is.read(car))!=-1){
			 String str=new String(car,0,len);
			 System.out.println(str);
		  }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ������ڣ�");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("��ȡ�ļ�ʧ�ܣ�");
		}finally{
			if(is!=null)
				try {
					//4���ͷ���Դ
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("�ر��ֽ���ʧ��!");
				}
		}
	}
}
