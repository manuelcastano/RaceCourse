package threads;

public class BetsThread implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(180000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
