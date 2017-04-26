package ThreadTest;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DaemonThreadFactory implements ThreadFactory{
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		t.setPriority(Thread.NORM_PRIORITY);
		return t;
	}
	
	Lock lock = new ReentrantLock();
	public void hhh(){
		lock.lock();
		lock.unlock();
		
	}
	
	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		final Condition notFull  = lock.newCondition();
		ClassUtil.printMethodMessage(notFull);
	}
}
