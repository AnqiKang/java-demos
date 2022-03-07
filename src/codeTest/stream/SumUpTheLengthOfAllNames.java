package codeTest.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumUpTheLengthOfAllNames {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(Arrays.asList(
                new Person("Anqi", "Kang"),
                new Person("Jingyu", "Zheng"),
                new Person("Mike", "Wang")));

        int sum = personList.stream()
                .mapToInt(p -> p.getFirstName().length() + p.getLastName().length())
                .sum();
        System.out.println(sum);


    }


    private static class Person {
        String firstName;
        String lastName;

        public Person() {
        }

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
