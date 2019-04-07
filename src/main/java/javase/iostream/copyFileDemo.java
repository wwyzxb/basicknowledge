package javase.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class copyFileDemo {
	public static void copyFile(String srcPath,String destPath) throws IOException{
		//1��������ϵ Դ��������Ϊ�ļ���+Ŀ�ĵأ��ļ����Բ����ڣ�
		File src=new File(srcPath);
		File dest=new File(destPath);
		copyFile(src, dest);
	}
	public static void copyFile(File srcFile,File destFile) throws IOException{
		//2��ѡ����
		InputStream is=new FileInputStream(srcFile);
		OutputStream os=new FileOutputStream(destFile);
		//3���ļ��Ŀ���  ѭ��+��ȡ+д��
		byte[] flush=new byte[1024];
		int len=0;
		//��ȡ
		while((len=is.read(flush))!=-1){
			//д��
			os.write(flush, 0, len);
		}
		os.flush();//ǿ��ˢ��
		//�ر���
		os.close();
		is.close();
		
	}
	public static void main(String[] args) throws IOException {
		String src="files/testOut.txt";
		String dest="files/testOut_copy.txt";
		copyFile(src,dest);
	}
}
