package ThreadTest;

public class LiftOffMain {
	public static void main(String[] args) {
		int count = 5;
		while(count-->0){
//			LiftOff launch = new LiftOff();
//			launch.run();
			new Thread(new LiftOff()).start();
		}
	}
}
