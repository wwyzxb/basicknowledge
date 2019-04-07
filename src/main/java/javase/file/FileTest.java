package javase.file;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
		File file=new File("files");
		if(file.exists()){
			File[] files=file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if(files[i].isDirectory()){
					System.out.println("�ļ��У�"+files[i].getName());
					files[i].delete();
				}
				else if (files[i].isFile()) {
					System.out.println("�ļ���"+files[i].getName());
				}
			}
		}
	}
}
