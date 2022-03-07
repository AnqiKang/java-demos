package codeTest.exam;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("john");
        Person p2 = new Person();
        p2.setName("john");
        System.out.println(p1.equals(p2));

    }


    private static class Person{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
