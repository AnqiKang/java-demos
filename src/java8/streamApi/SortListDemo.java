package java8.streamApi;

import java.util.*;

public class SortListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(8, 3, 12, 4));

//        Collections.sort(list);
//        System.out.println(list);
//
//        Collections.reverse(list);
//        System.out.println(list);

//        list.stream().sorted().forEach(System.out::println);
//
//        // descending
//        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee(176, "Roshan", "IT", 600000),
                new Employee(388, "Bikash", "CIVIL", 900000),
                new Employee(470, "Bimal", "DEFENCE", 500000),
                new Employee(624, "Sourav", "SORE", 400000),
                new Employee(176, "Prakash", "SOCIAL", 1200000)
        ));

        // sort based on salary
        //Collections.sort(employeeList, (o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));
        //System.out.println(employeeList);

        // employeeList.stream().sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())).forEach(System.out::println);
        // employeeList.stream().sorted(Comparator.comparing(emp-> emp.getSalary())).forEach(System.out::println);
        employeeList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

        // stream api
        employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getId)
                        .thenComparing(Employee::getSalary))
                .forEach(System.out::println);

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
