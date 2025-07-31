package com.example.dsa;

import java.util.*;

// A customer list given that have id ,name , city
// group count by city : mysql, java 7, java 8
// group count by city and name: mysql, java7, java8
class Customer{
    public int id ;
    public String name ;
    public String city ;

    public Customer(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}


public class App1 {
    public static void main(String[] args) {
      List<Customer> customers = new ArrayList<Customer>();
      customers.add(new Customer(100 , "raj" , "bbsr"));
      customers.add(new Customer(100 , "raj" , "bbsr"));
      customers.add(new Customer(101 , "mital" , "ctc"));
      customers.add(new Customer(102 , "sim" , "ctc"));
      customers.add(new Customer(100 , "raj" , "bbsr"));

        Map<String ,Integer> cityCount = new HashMap<>();

        for (Customer customer : customers){
            String city = customer.city ;
            if (cityCount .containsKey(city)){
                cityCount.put(city , cityCount.get(city)+1);
            }else {
                cityCount.put(city ,1);
            }
        }
        System.out.println("customer count by city ");
        for (Map.Entry<String , Integer> entry : cityCount.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
