package codeTest.keepInMind;

public class SingletonLazyThreadSafeDemo {

    // 创建instance
    private static volatile SingletonLazyThreadSafeDemo instance;

    // 构造函数私有化
    private SingletonLazyThreadSafeDemo() {
    }

    // 对外暴露一个方法获取类的对像
    public static SingletonLazyThreadSafeDemo getInstance() {
        if (instance == null) { // first check
            synchronized (SingletonLazyThreadSafeDemo.class) { // lock
                if (instance == null) { // second check
                    instance = new SingletonLazyThreadSafeDemo();
                }
            }
        }
        return instance;
    }


}
