package com.vti.entity;

import javax.persistence.*;

@Entity
@Table(name = "shape")
@Inheritance(strategy = InheritanceType.JOINED)
public class Shape {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "name", length = 50, nullable = false)
    protected String name;

    public Shape() {
    }

    public Shape(String name) {
        this.name = name;
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
}
