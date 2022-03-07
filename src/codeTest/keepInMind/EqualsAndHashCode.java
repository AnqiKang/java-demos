package codeTest.keepInMind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsAndHashCode {

    public static void main(String[] args) {

        Set<User> userList = new HashSet<>(Arrays.asList(
                new User("Kare", 20),
                new User("Anqi", 27),
                new User("Tom", 35),
                new User("Jingyu", 32),
                new User("Kare", 20),
                new User("Kare", 20)
        ));
        System.out.println(userList.size());
    }


    private static class User {
        String name;
        int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // equals()



        // hashCode()


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
