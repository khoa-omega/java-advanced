package com.vti.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id", nullable = false)

    /* Implicit sequence */
    /* @GeneratedValue(strategy = GenerationType.SEQUENCE) */

    /* Named sequence */
    /* @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    ) */

    /* Simple @SequenceGenerator */
    /* @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-generator"
    )
    @SequenceGenerator(
            name = "sequence-generator",
            sequenceName = "student_sequence",
            initialValue = 2,
            allocationSize = 10
    ) */

    /* @GenericGenerator */
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_generator"
    )
    @GenericGenerator(
            name = "student_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "student_sequence"),
                    @Parameter(name = "initial_value", value = "10"),
                    @Parameter(name = "increment_size", value = "1"),
                    @Parameter(name = "optimizer", value = "pooled-lo")
            }
    )
    private int id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    public Student() {
    }

    public Student(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
