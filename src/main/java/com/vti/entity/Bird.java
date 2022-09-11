package com.vti.entity;

public class Bird extends Animal implements IAnimal {
    public Bird(int id, String name) {
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
