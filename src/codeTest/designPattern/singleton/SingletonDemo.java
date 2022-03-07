package codeTest.designPattern.singleton;

public class SingletonDemo {

    // 创建instance
    private static volatile SingletonDemo instance;

    // private constructor
    private SingletonDemo() {
    }



    // public static method -- get instance
    public static SingletonDemo getInstance() {
        if (instance == null) { // lock 1
            synchronized (SingletonDemo.class) {
                if (instance == null) { // lock 2
                    instance = new SingletonDemo();
                }
            }

        }
        return instance;
    }


}
