package javase.iostream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class StreamTest {
	public static void main(String[] args) {
		int c;
		try {
			InputStream is=new MyOwnIOStream(new BufferedInputStream(new FileInputStream("files\\test.txt")));
			while((c=is.read())>=0){
				System.out.print((char)c+" ");
			}
			is.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
