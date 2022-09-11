package com.vti.entity;

public class Dog extends Animal implements IAnimal {
    public Dog(int id, String name) {
        super(id, name);
    }

    @Override
    public void flyable() {

    }

    @Override
    public void runnable() {

    }

    @Override
    public void jumpable() {

    }

    @Override
    public void swimmable() {

    }
}
