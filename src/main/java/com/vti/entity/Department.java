package com.vti.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
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

    @Column(name = "type", nullable = false)
    @Convert(converter = DepartmentTypeConvert.class)
    private Type type;

    @Column(name = "created_date", nullable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

    public Department(int id) {
        this.id = id;
    }

    public Department(String name, int totalMembers, Type type) {
        this.name = name;
        this.totalMembers = totalMembers;
        this.type = type;
    }

    public Department(int id, String name, int totalMembers, Type type) {
        this.id = id;
        this.name = name;
        this.totalMembers = totalMembers;
        this.type = type;
    }
}
