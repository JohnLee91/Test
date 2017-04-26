package ThreadTest;

public class FibonacciMain {
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            new Thread(new Fibonacci(i+1)).start();
        }
    }
}
