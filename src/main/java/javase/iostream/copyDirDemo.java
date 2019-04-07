package javase.iostream;

import java.io.File;
import java.io.IOException;

public class copyDirDemo {
	public static void copyDirDetail(File src,File dest) {
		if(src.isFile()){//���ļ�ֱ�ӿ���
			try {
				copyFileDemo.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("�ļ�����ʧ��");
			}
		}else if (src.isDirectory()) {//���ļ���
			//ȷ��Ŀ���ļ��д���
			dest.mkdir();
			//��ȡ��һ���ļ�/�ļ���
			for(File sub:src.listFiles()){
				copyDirDetail(sub, new File(dest, sub.getName()));//�ݹ���ÿ���
			}
		}

	}
	public static void copyDir(File src,File dest) {
		if(src.isDirectory()){//���ļ���
			dest=new File(dest,src.getName());
		}
		copyDirDetail(src,dest);
	}
	public static void main(String[] args) throws IOException {
		String srcPath="G:/test";
		String destPath="G:/dir";
		File src=new File(srcPath);
		File dest=new File(destPath);
		copyDir(src, dest);
		
	}

}
