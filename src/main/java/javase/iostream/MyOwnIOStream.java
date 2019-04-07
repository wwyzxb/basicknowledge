package javase.iostream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyOwnIOStream extends FilterInputStream{

	protected MyOwnIOStream(InputStream in) {
		super(in);
	}
	public int read() throws IOException{
		int c=0;
		if((c=super.read())!=-1){
			if(Character.isLowerCase((char)c))
				return Character.toUpperCase((char)c);
			else if (Character.isUpperCase((char)c)) 
				return Character.toLowerCase((char)c);
			else return c;
		}else {
			return -1;
		}
	}

}
