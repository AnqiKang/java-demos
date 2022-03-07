package java8.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * avoid NullPointerException
 * methods:
 *      empty()
 *      of(T value)  -- if we assume our object is never not null
 *      ofNullable(T value) -- if we assume our object might be null
 *
 *      get() -- get exact value, but if the value is null, throws exception
 *      isPresent() -- true / false, check is it has value or not
 *
 *      orElse() -- if value is null, give it default value
 *      orElseThrow() -- if value is null, throw a customized exception
 *      orElseGet() -- if value null, get() default value
 *
 *
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Customer customer = new Customer(101, "john", null, Arrays.asList("976755", "23738934"));

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional); //Optional.empty

        // if object is null, throw exception,
        //  if object is not null, return Optional[value]
//        Optional<String> emailOptional = Optional.of(customer.getEmail());
//        System.out.println(emailOptional);

        // if object is null, return Optional.empty.
        // if object is not null, return Optional[value]
        Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
        System.out.println(emailOptional2); // Optional.empty


        //get value from Optional
        // if the value is null, get NoSuchElementException
        //System.out.println(emailOptional2.get());
        if(emailOptional2.isPresent()){
            System.out.println(emailOptional2.get());
        }

        // if value is null, give it default value
       // System.out.println(emailOptional2.orElse("default@gmail.com"));

        // throws custom exception when value if null
       // System.out.println(emailOptional2.orElseThrow(()-> new IllegalArgumentException("email not present")));

        System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(()-> "default@gmail.com"));
        System.out.println(Optional.ofNullable(customer.getName()).map(String::toUpperCase).orElseGet(()->"default name"));







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
