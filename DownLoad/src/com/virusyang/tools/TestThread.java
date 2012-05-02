package com.virusyang.tools;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {
	public static long t=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		
		TestThread2 tt = new TestThread2();
		System.out.println(t=System.currentTimeMillis());
		new Thread(tt).start();
		new Thread(tt).start();
		new Thread(tt).start();
		new Thread(tt).start();
		new Thread(tt).start();
		
	}
}

class TxtThread implements Runnable {
	int num = 100;
	String str = new String();

	public void run() {
		while (num > 0) {
			synchronized (str) {
				if (num > 0) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.getMessage();
					}
					System.out.println(Thread.currentThread().getName()
							+ "this is " + num--);
				}
			}
		}
	}
}

class TestThread2 implements Runnable {
	int num = 100;
	String str = new String();

	@Override
	public void run() {
		Lock lock=new ReentrantLock();
		while (num > 0) {
			lock.lock();
			try {
				
				boolean b=lock.tryLock(100,TimeUnit.MILLISECONDS);
				if(b==true){
				if (num > 0) {
					Thread.sleep(100);
				}
				for(int i=0;i<1000000000;i++)
				{
					i=i++;
				}
				if(num==0){
					return;
				}
				System.out.println(Thread.currentThread().getName()
						+ "this is " + num--);
				}else{
					System.out.println("i am not use @");
				}
			} catch (Exception e) {
				e.getMessage();
			}finally{
			lock.unlock();
			}
		}
		System.out.println("cost time is: "+(System.currentTimeMillis()-TestThread.t));
	}

}
