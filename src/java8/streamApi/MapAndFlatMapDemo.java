package java8.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMapDemo {
    public static void main(String[] args) {

        // transformation:  [ a,b,c,d] --> [A,B,C,D]
        List<String> mapEx = Stream.of("a", "b", "c", "d").map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(mapEx);

        // flattering: convert stream of stream into single stream
        // [[1,2],[3,4],[5,6],[7,8]] --> [1,2,3,4,5,6,7,8]
        List<List<Integer>> numList = new ArrayList<>();
        numList.add(new ArrayList<>(Arrays.asList(1, 2)));
        numList.add(new ArrayList<>(Arrays.asList(3, 4)));
        numList.add(new ArrayList<>(Arrays.asList(5, 6)));
        numList.add(new ArrayList<>(Arrays.asList(7, 8)));
        List<Integer> flatMapEx = numList.stream().flatMap(n -> n.stream()).collect(Collectors.toList());
        System.out.println(flatMapEx);

        List<Customer> customerList = Arrays.asList(
                new Customer(101, "john", "john@gmial.com", Arrays.asList("12345", "23453")),
                new Customer(102, "smith", "smith@gmial.com", Arrays.asList("9872", "23453")),
                new Customer(103, "peter", "peter@gmial.com", Arrays.asList("2462", "5643")),
                new Customer(104, "kelly", "kelly@gmial.com", Arrays.asList("327836", "29038"))
        );

        // get all email for each customer -- list of email
        // mapping logic/ transformation: customer -> customer.getEmail() -- one to one mapping
        List<String> emailList = customerList.stream().map(c -> c.getEmail()).collect(Collectors.toList());
        System.out.println(emailList);

        // get all phone based on customer
        // no flatting: List<List<String>>. one to one mapping:
        List<List<String>> phoneListForEachCustomer = customerList.stream().map(c -> c.getPhoneNumber()).collect(Collectors.toList());
        System.out.println(phoneListForEachCustomer);

        // get all phone
        // flatting : List<String> ; one to many
        List<String> phoneList = customerList.stream().flatMap(c -> c.getPhoneNumber().stream()).collect(Collectors.toList());
        System.out.println(phoneList);

    }


    private static class Customer {
        int id;
        String name;
        String email;
        List<String> phoneNumber;

        public Customer() {
        }

        public Customer(int id, String name, String email, List<String> phoneNumber) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public List<String> getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(List<String> phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", phoneNumber=" + phoneNumber +
                    '}';
        }
    }
}
