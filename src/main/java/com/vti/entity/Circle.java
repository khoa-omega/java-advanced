package com.vti.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "circle")
@AttributeOverrides(value = {
        @AttributeOverride(name = "id", column = @Column(name = "id", length = 50, nullable = false)),
        @AttributeOverride(name = "name", column = @Column(name = "name", length = 50, nullable = false))
})
public class Circle extends Shape {
    @Column(name = "radius", nullable = false)
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
