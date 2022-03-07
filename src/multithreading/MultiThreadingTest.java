package multithreading;

public class MultiThreadingTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }

    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("my thread run()");
    }

    @Override
    public void start() {
        System.out.println("my thread start()");
    }
}
