package com.vti.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id", length = 36, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Convert(converter = StudentGenderConverter.class)
    private Gender gender;

    public void setName(String name) {
        this.name = name;
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
            return code == 'M' ? MALE : FEMALE;
        }
    }
}
