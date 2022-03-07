package codeTest.exam;

public class Parent2 {
    protected void printHello() {
        System.out.println("Hello from parent");
    }
}

class Child2 extends Parent2 {
    @Override
    public void printHello(){
        System.out.println("Hello from Child");
    }
}


class Caller{
    public static void main(String[] args) {
        Parent2 parent = new Child2();
        parent.printHello();
    }
}
