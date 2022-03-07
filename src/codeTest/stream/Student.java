package codeTest.stream;

import java.util.List;

public class Student {
    private  String name;
    private List<String> courses;
    private static volatile Student student = new Student();

    private Student() {

    }
    public static Student getInstance(){
        if(student == null){
            synchronized (Student.class){
                if(student == null){
                    student = new Student();
                }
            }
        }
        return student;
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
