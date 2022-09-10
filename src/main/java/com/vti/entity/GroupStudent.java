package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "group_student")
@IdClass(value = GroupStudentPK.class)
public class GroupStudent {
    @Id
    @Column(name = "group_id")
    private int groupId;

    @Id
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "joined_date", nullable = false)
    @CreationTimestamp
    private LocalDate joinedDate;

    public GroupStudent() {
    }

    public GroupStudent(int groupId, int studentId) {
        this.groupId = groupId;
        this.studentId = studentId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
                "groupId=" + groupId +
                ", studentId=" + studentId +
                ", joinedDate=" + joinedDate +
                '}';
    }
}
