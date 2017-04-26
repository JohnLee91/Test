package IOTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class FileList {
	public static void main(String[] args) throws IOException {
		File path = new File(".");
		String[] list = path.list(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(".+[a-zA-Z]{5}");
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});
		//String[] list = path.list();
		
		for (String string : list) {
			System.out.println(string);
		}
		reader();
	}
	
	public static void reader() throws IOException{
//		BufferedInputStream dis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\lenovo\\Desktop\\1.txt")));
//		System.out.println(dis.read());
//		System.out.println(dis.read());
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\lenovo\\Desktop\\1.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(fis,"gbk"));
		String info = null;
		while((info = br.readLine())!=null){
			System.out.println(info);
		}
		
		br.close();
		fis.close();
		
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\lenovo\\Desktop\\1.txt"));
		PrintWriter bw = new PrintWriter(new OutputStreamWriter(fos,"gbk"));
		bw.append("你好");
		bw.flush();
		

		bw.close();
		fos.close();
	}
}
