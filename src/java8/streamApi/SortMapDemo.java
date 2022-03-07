package java8.streamApi;

import java.util.*;

public class SortMapDemo {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Eight", 8);
        map.put("four", 4);
        map.put("ten", 10);
        map.put("two", 2);

        // no stream
//        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
//        Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
//
//        for (Map.Entry<String, Integer> entry : entries) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        // Stream API
//        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(obj -> System.out.println(obj));
//        System.out.println("--------------");
//        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(obj -> System.out.println(obj));
//        System.out.println("--------------");

        // Comparator: sort based on salary
        Map<Employee, Integer> empMap = new HashMap<>();

        empMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
        empMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
        empMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
        empMap.put(new Employee(624, "Sourav", "SORE", 400000), 40);
        empMap.put(new Employee(176, "Prakash", "SOCIAL", 1200000), 120);

        // System.out.println( empMap);

        // descending order
        // (o1, o2) -> (int) (o2.getSalary() - o1.getSalary())

        // reverse order : based on salary
//        empMap.entrySet().stream()
//                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary)
//                        .reversed())).forEach(System.out::println);

        // then comparing
        empMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getId)
                        .thenComparing(Comparator.comparingLong(Employee::getSalary))))
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
