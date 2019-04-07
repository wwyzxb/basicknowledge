package javase.iostream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileRead_FileRead {
	public static void Reader(File src) {
		//2��ѡ���ֽ���
		Reader r=null;
		try {
			r=new FileReader(src);
			//3�����ж�ȡ
			char[] ch=new char[100];
			int len=0;
			try {
				while((len=r.read(ch))!=-1){
					//���ַ�����ת�����ַ���
					String str=new String(ch,0,len);
					System.out.println(str);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(r!=null){
				//4���ر��ֽ���
				try {
					r.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		String srcPath="files/writeDemo.txt";
		//1��������ϵ
		File src=new File(srcPath);
		Reader(src);
	}

}
