package codeTest;

import java.util.List;

public class SingletonTest {
    private static volatile SingletonTest instance;
    private Student student = new Student();

    private SingletonTest() {}


    public static SingletonTest getInstance() {
        if (instance == null) {
            synchronized (SingletonTest.class) {
                if (instance == null) {
                    instance = new SingletonTest();
                }
            }

        }
        return instance;

    }

}

class Student {
    private String name;
    private List<String> courses;

    public Student() {
        // TODO Auto-generated constructor stub
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

}
