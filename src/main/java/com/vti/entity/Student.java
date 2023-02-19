package com.vti.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "code", length = 10, unique = true, nullable = false)
    @GenericGenerator(
            name = "student-code-generator",
            strategy = "com.vti.entity.StudentCodeGenerator",
            parameters = @Parameter(name = "prefix", value = "VA")
    )
    @GeneratedValue(generator = "student-code-generator")
    private String code;

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
                "code=" + code +
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
