package java8.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterRealDemo {


    public static void main(String[] args) {
        System.out.println(evaluateTexUsers("tax"));
        System.out.println(evaluateTexUsers("non tax"));
    }

    public static List<Employee> evaluateTexUsers(String input) {
        return input.equalsIgnoreCase("tax") ?
                getEmployee().stream().filter(em -> em.getSalary() > 500000).collect(Collectors.toList()) :
                getEmployee().stream().filter(em -> em.getSalary() <= 500000).collect(Collectors.toList());


    }

    private static List<Employee> getEmployee() {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee(176, "Roshan", "IT", 600000),
                new Employee(388, "Bikash", "CIVIL", 900000),
                new Employee(470, "Bimal", "DEFENCE", 500000),
                new Employee(624, "Sourav", "SORE", 400000),
                new Employee(176, "Prakash", "SOCIAL", 1200000)
        ));
        return employeeList;
    }

    private static class Employee {
        int id;
        String name;
        String dept;
        long salary;

        public Employee(int id, String name, String dept, long salary) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
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
                    ", name='" + name + '\'' +
                    ", dept='" + dept + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
