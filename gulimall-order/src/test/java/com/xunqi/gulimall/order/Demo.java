package com.xunqi.gulimall.order;

import lombok.Data;
import org.junit.Test;

import java.time.Period;

public class Demo {
    @Data
    public class Address implements Cloneable{
        private String name;
        // 省略构造函数、Getter&Setter方法
        public Address(String name){
            this.name=name;
        }
        @Override
        public Address clone() {
            try {
                return (Address) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
@Data
    public class Person implements Cloneable {
        private Address address;
        // 省略构造函数、Getter&Setter方法
        public Person (Address address){
            this.address=address;
        }
        @Override
        public Person clone() {
            try {
                Person person = (Person) super.clone();
//                Address clone = person.getAddress().clone();
//                person.setAddress(clone);
                return person;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
@Test
    public  void maina() {
        Person person = new Person(new Address("dddd"));
        Person person1=person.clone();
        System.out.println(person.getAddress()==person1.getAddress());
    }
}
