package com.vti.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "code", length = 50)
    @GenericGenerator(
            name = "student-code-generator",
            strategy = "com.vti.entity.StudentCodeGenerator"
    )
    @GeneratedValue(generator = "student-code-generator")
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
                "code=" + code +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
