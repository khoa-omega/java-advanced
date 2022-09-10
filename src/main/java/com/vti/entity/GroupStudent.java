package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "group_student")
public class GroupStudent {
    @EmbeddedId
    private GroupStudentPK id;

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

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    @Override
    public String toString() {
        return "GroupStudent{" +
                "id=" + id +
                ", joinedDate=" + joinedDate +
                '}';
    }
}
