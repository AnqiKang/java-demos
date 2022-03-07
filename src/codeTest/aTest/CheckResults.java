package codeTest.aTest;

public class CheckResults {
    private static int counter = 0;

    public static void main(String[] args) {

        new Thread(()->{
            counter++;
        }).start();

        new Thread(()->{
            counter++;
        }).start();

        new Thread(()->{
            counter++;
        }).start();

        System.out.println("Counter is ! " + counter);
    }
}
