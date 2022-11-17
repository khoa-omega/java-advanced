package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(
            name = "sequence-generator",
            sequenceName = "student_sequence",
            initialValue = 2
    )
    private int id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Convert(converter = StudentGenderConverter.class)
    private Gender gender;

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

    public enum Gender {
        MALE('M'), FEMALE('F');

        private final char code;

        Gender(char code) {
            this.code = code;
        }

        public char getCode() {
            return code;
        }

        public static Gender fromCode(char code) {
            if (code == 'M' || code == 'm') {
                return MALE;
            }
            if (code == 'F' || code == 'f') {
                return FEMALE;
            }
            throw new UnsupportedOperationException("The code is unsupported.");
        }
    }
}
