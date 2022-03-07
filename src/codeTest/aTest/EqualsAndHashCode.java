package codeTest.aTest;

import java.util.*;

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

        @Override
        public boolean equals(Object obj) {
            // 地址是否一样
            if (this == obj) {
                return true;
            }

            // 非空 和 class 类型判断
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // 强转
            User user = (User) obj;

            // 字段匹配
            return age == user.age && name.equals(user.name);

        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
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
