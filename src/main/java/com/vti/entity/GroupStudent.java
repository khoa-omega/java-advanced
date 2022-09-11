package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "group_student")
public class GroupStudent {
    @EmbeddedId
    private GroupStudentPK id;

    @ManyToOne
    @MapsId(value = "group_id")
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @MapsId(value = "student_id")
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "joined_date", nullable = false)
    @CreationTimestamp
    private LocalDate joinedDate;

    public GroupStudent() {
    }

    public GroupStudent(GroupStudentPK id) {
        this.id = id;
    }

    public GroupStudentPK getId() {
        return id;
    }

    public void setId(GroupStudentPK id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }
}
