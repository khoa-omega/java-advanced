package com.vti.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "group")
    private List<GroupStudent> groupStudents;

    public Group() {
    }

    public Group(int id) {
        this.id = id;
    }

    public Group(String name) {
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

    public List<GroupStudent> getGroupStudents() {
        return groupStudents;
    }

    public void setGroupStudents(List<GroupStudent> groupStudents) {
        this.groupStudents = groupStudents;
    }
}
