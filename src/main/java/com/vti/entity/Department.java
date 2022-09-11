package com.vti.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "total_members", nullable = false)
    private int totalMembers;

    public Department(String name, int totalMembers) {
        this.name = name;
        this.totalMembers = totalMembers;
    }

    public Department(int id, String name, int totalMembers) {
        this.id = id;
        this.name = name;
        this.totalMembers = totalMembers;
    }
}
