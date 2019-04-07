package javase.iostream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWrite_FileWrite {
	public static void main(String[] args) {
		//1����������
		File dest= new File("files/FileWriteDemo.txt");
		String str="/files/FileWriteDemo.txt";
		//2��ѡ���ַ���
		Writer w=null;
		try {
			//3��д���ļ�
			w=new FileWriter(dest);
			w.write(str);
			w.flush();//ǿ��ˢ��
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null!=w){
				try {
					//4���ر��ֽ���
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
