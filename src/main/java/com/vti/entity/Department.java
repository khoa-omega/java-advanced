package com.vti.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
@NamedQueries({
        @NamedQuery(
                name = "Department.searchByName",
                query = "FROM Department WHERE name LIKE ?1"
        ),
        @NamedQuery(
                name = "Department.deleteByName",
                query = "DELETE FROM Department WHERE name = ?1"
        )
})
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "total_members", nullable = false)
    private int totalMembers;

    public Department() {
    }

    public Department(String name, int totalMembers) {
        this.name = name;
        this.totalMembers = totalMembers;
    }

    public Department(int id, String name, int totalMembers) {
        this.id = id;
        this.name = name;
        this.totalMembers = totalMembers;
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

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalMembers=" + totalMembers +
                '}';
    }
}
