package codeTest.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1.	input: List<Employee>, Employee(name, salary, age)
 * Coding:
 * Lambda: return a list of employee names where salary is larger than 10000 in the desc order of their age.
 */
public class DecsOrderOfAge {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee("Karen", 1009.90, 27),
                new Employee("Mike", 1029.70, 37),
                new Employee("Tom", 1000.00, 20),
                new Employee("Jerry", 899.79, 25),
                new Employee("Tim", 2210.2, 30)
        ));
        List<Employee> res = employeeList.stream()
                .filter(p-> p.getSalary() > 1000.00)
                .sorted((e1,e2)->e2.getAge() - e1.getAge()).collect(Collectors.toList());
        System.out.println(res);

    }

    private static class Employee {
        String name;
        double salary;
        int age;

        public Employee() {
        }

        public Employee(String name, double salary, int age) {
            this.name = name;
            this.salary = salary;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", age=" + age +
                    '}';
        }
    }
}
