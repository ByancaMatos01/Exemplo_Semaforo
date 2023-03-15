package view;

import java.util.concurrent.Semaphore;

import Controller.ThreadOp;

public class Principal {

	public static void main(String[] args) {
			Semaphore mutex = new Semaphore(1);
			for (int idThread = 2; idThread <= 3; idThread++) {
				Thread t = new ThreadOp(idThread, mutex);
				t.start();
			}
		}

	}


