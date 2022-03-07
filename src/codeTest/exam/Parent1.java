package codeTest.exam;

/**
 * what is output?
 */
public class Parent1 {
    public Parent1() {
        System.out.println("Printing in parent constructor");
    }

}

class Child1 extends Parent1 {
    public Child1() {
        System.out.println("Printing in child constructor");
    }
}

class CallerCode {
    public static void main(String[] args) {
        Parent1 parent = new Child1();
    }
}
