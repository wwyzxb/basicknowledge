package javase.file;

import java.io.File;

public class FileFunTest {
	private static void printName(String src) {
		File file=new File(src);
		File[] files=file.listFiles();
		for(File f:files){
			if(f.isDirectory())
				printName(f.getAbsolutePath());
			else if (f.isFile()) {
				System.out.println(f.getAbsolutePath());
			}
		}
	}
	public static void main(String[] args) {
		printName("C:/Users/Vincent/workspace/Local_JavaTest");
	}

}
