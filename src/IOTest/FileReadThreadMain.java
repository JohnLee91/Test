package IOTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileReadThreadMain {
	
	//TODO 为什么加锁之后还是不对呢？
	public static void main(String[] args) {
		String filePath = "C:\\Users\\lenovo\\Desktop\\1.txt";
		ExecutorService es = Executors.newCachedThreadPool();
		Long start = System.currentTimeMillis();
		Long cur = start;
		for (int i = 0; i < 1000; i++) {
			es.execute(new FileReadThread(filePath));
		}
		es.shutdown();

		while(FileReadThread.count!=1000){
			if ((System.currentTimeMillis()-cur)>5000) {
				cur = System.currentTimeMillis();
				System.out.println(FileReadThread.count);
				System.out.println(FileReadThread.count1);
			}
		}
		System.out.println(System.currentTimeMillis()-start);
	}
	
}
