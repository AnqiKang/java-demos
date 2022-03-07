package java8.streamApi;

import java.util.Arrays;
import java.util.List;

public class OptionalStreamDemo {
    public static void main(String[] args) throws Exception {
        getCustomerByEmailId("pqr");

    }


    private static Customer getCustomerByEmailId(String email) throws Exception {
        List<Customer> customers = getCustomers();
        return customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny().orElseThrow(() -> new Exception("no customer present with this email"));


    }

    public static List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(101, "john", "john@gmial.com", Arrays.asList("12345", "23453")),
                new Customer(102, "smith", "smith@gmial.com", Arrays.asList("9872", "23453")),
                new Customer(103, "peter", "peter@gmial.com", Arrays.asList("2462", "5643")),
                new Customer(104, "kelly", "kelly@gmial.com", Arrays.asList("327836", "29038"))
        );
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
