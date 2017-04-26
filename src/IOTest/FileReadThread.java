package IOTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileReadThread implements Runnable{
	
	private String filePath;
	public static volatile int count = 0;
	public static volatile int count1 = 1000;
	
	public FileReadThread(String filePath) {
		super();
		this.filePath = filePath;
	}

	@Override
	public void run() {
		Lock lock = new ReentrantLock();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)),"gbk"));
			String line = null;
			while((line=br.readLine())!= null){
				System.out.println(line);
			}
//			synchronized (this) {
//				count++;
//				count1--;
//			}
			lock.lock();
			try{
				count++;
				count1--;
			}finally{
				lock.unlock();
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
