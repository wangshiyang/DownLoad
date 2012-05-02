package com.virusyang.tools;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest2 {

	/**
	 * @param args
	 */
	private static long c = 0;

	public static void main(String[] args) {
		final Lock l = new ReentrantLock();
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 10;) {
					try {
						l.lock();
						c++;
						i++;

						System.out.println(Thread.currentThread().getName()
								+ " t1 this is " + c);
						l.unlock();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 10;) {

					try {
						if (l.tryLock(250, TimeUnit.MILLISECONDS)) {
							c++;
							i++;
							System.out.println(Thread.currentThread().getName()
									+ " t2 this is " + c);
							l.unlock();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		};
		long t = System.currentTimeMillis();
		Thread t3 = new Thread() {
			public void run() {
				for (int i = 0; i < 10;) {
					try {
						if (l.tryLock()) {
							c++;
							i++;

							System.out.println(Thread.currentThread().getName()
									+ " t3 this is " + c);
							l.unlock();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Thread t4 = new Thread() {
			public void run() {
				for (int i = 0; i < 10;) {
					try {
						if (l.tryLock()) {
							c++;
							i++;

							System.out.println(Thread.currentThread().getName()
									+ " t4 this is " + c);
							l.unlock();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		t2.start();
		t1.start();
		t3.start();
		t4.start();

	}

}
