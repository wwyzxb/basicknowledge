package javase.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOTest {
	public static void main(String[] args) throws IOException {
		File inFile=new File("files\\testIn.txt");
		File outFile=new File("files\\testOut.txt");
		if(!outFile.exists()){
			outFile.createNewFile();
		}
		BufferedReader br=new BufferedReader(new FileReader(inFile));
		BufferedWriter bw=new BufferedWriter(new FileWriter(outFile));
		if(inFile.exists()){
			String line=br.readLine();
			while(line!=null){
				bw.write(line);
				line=br.readLine();
			}
		}
		br.close();
		bw.close();
	}

}
