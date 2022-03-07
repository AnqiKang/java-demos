package java8.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * map - reduce is a functional programming model it servers 2 purpose.
 * map    : transforming data
 * reduce : aggregating data -- combine elements of a stream and produces a single value
 * <p>
 * T reduce(T identity, BinaryOperator<T> accumulator
 * identity : the initial value of type T
 * 0 means no initial value
 * accumulator : a function for combining 2 values
 */
public class MapAndReduceRealDemo {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee(176, 'A', "Roshan", "IT", 60000),
                new Employee(388, 'B', "Bikash", "CIVIL", 30000),
                new Employee(470, 'A', "Bimal", "DEFENCE", 80000),
                new Employee(624, 'A', "Sourav", "SORE", 90000),
                new Employee(176, 'C', "Prakash", "SOCIAL", 15000)
        ));

        // evaluate average salary of Grade A employees
        // filter Grade A emp, map to number (salaries) , reduce to average
        double avgSalary = employeeList.stream()
                .filter(emp -> emp.getGrade() == 'A')
                .map(Employee::getSalary)
                .mapToDouble(i -> i)
                .average().getAsDouble();
        System.out.println(avgSalary);

        // sum of salary with grade 'A'
        Long sumSalary = employeeList.stream()
                .filter(emp -> emp.getGrade() == 'A')
                .map(Employee::getSalary)
                .mapToLong(i -> i)
                .sum();
        System.out.println(sumSalary);

    }

    private static class Employee {
        int id;
        char grade;
        String name;
        String dept;
        long salary;


        public Employee(int id, char grade, String name, String dept, long salary) {
            this.id = id;
            this.grade = grade;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }

        public char getGrade() {
            return grade;
        }

        public void setGrade(char grade) {
            this.grade = grade;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public long getSalary() {
            return salary;
        }

        public void setSalary(long salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", grade=" + grade +
                    ", name='" + name + '\'' +
                    ", dept='" + dept + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
