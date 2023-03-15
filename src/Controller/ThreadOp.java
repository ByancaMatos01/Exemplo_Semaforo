package Controller;

import java.util.concurrent.Semaphore;

public class ThreadOp extends Thread {

	private int idThread;
	private static double res;
	private Semaphore mutex;
	
	public ThreadOp(int idThread, Semaphore mutex) {
		this.idThread = idThread;
		this.mutex = mutex;
	}

	@Override
	public void run() {
		try {
			mutex.acquire();
			op();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			mutex.release();
		}
		
	}

	private void op() {
		res = 1;
		if (idThread % 2 == 0) {
			for (double i = 1 ; i <= 10 ; i++) {
				res = res * i;
				System.out.println(res);
			}
		} else {
			for (double i = 1 ; i <= 10 ; i++) {
				res = res / i;
				System.out.println(res);
			}
		}
	}
	
}
