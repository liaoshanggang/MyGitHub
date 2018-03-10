
public class MyThread implements Runnable{
	int tally = 0;

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			tally+=1;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 500; i++) {
			test();
		}
		
	}
	public static void  test() {

		MyThread p = new MyThread();
		Thread thread = new Thread(p);
		Thread thread2 = new Thread(p);
		thread.start();
		thread2.start();
		try {
			thread.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(p.tally);
	}
}
