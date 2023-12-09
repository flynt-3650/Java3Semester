/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package genericloophole;

import java.io.Serializable;

class Animal implements Serializable {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    public void makeSound() {
        System.out.println("The animal makes a sound.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


record GenericClass<T extends Comparable<String>, V extends Animal, K>(T t, V v, K k) {

    public void printTypes() {
        System.out.print("k type: " + k.getClass().getName());
        System.out.print("v type: " + v.getClass().getName());
        System.out.print("k type: " + t.getClass().getName());
    }

    public static void main(String[] args) {
        // Create an instance of Animal
        Animal animal = new Animal("Leo", 5);
        animal.makeSound();

        // Create an instance of GenericLoophole
        String t = "Hello, world!";
        GenericClass<String, Animal, Integer> genericLoophole = new GenericClass<>(t, animal, 42);

        // Get and print the values of T, V, and K
        String tValue = genericLoophole.t();
        Animal vValue = genericLoophole.v();
        Integer kValue = genericLoophole.k();

        System.out.println("Value of T: " + tValue);
        System.out.println("Value of V: " + vValue.getName() + ", Age: " + vValue.getAge());
        System.out.println("Value of K: " + kValue);

        // Print the types of T, V, and K
        genericLoophole.printTypes();
    }
}



