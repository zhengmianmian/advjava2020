package cn.tju.chp08.s08.stopthread;

public class StopSleep2 {
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = ()->{
			int count = 0;
			try {
				while(count<=10000 ) {
					if (count %100==0) {
						System.out.println(count + "是100的倍数");
					}
					count++;
					Thread.sleep(10);
				} 
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		Thread.sleep(5000); 
		thread.interrupt(); //当前面的线程正在运行的时候，中断
	}

}
