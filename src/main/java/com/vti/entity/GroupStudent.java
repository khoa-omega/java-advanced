package com.vti.entity;

import javax.persistence.*;

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
}
