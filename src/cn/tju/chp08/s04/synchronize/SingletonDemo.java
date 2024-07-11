package cn.tju.chp08.s04.synchronize;

class Singleton{
	private static Singleton singleton = null;
	private Singleton(){
		System.out.println("这是一个实例");
		
	}
	
	public static Singleton getInstance(){
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton==null){
					singleton = new Singleton();
				}
			}			
		}
		
//		synchronized (Singleton.class) {
//				if (singleton==null){
//					singleton = new Singleton();
//				}			
//		}
		
//		if (singleton == null) {
//			synchronized (Singleton.class) {
//				singleton = new Singleton();
//			}			
//		}
//		
//		if (singleton == null) {
//			singleton = new Singleton();
//			
//		}
		
		
		return singleton;
	}
}

class SThread implements Runnable{
	@Override
	public void run() {
		Singleton.getInstance();
	}
}

public class SingletonDemo {

	public static void main(String[] args) {
		SThread st = new SThread();
		Thread t1 = new Thread(st);
		t1.start();
		Thread t2 = new Thread(st);
		t2.start();

	}

}
