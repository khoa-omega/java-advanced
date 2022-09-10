package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class GroupStudentPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "group_id", nullable = false)
    private int groupId;

    @Column(name = "student_id", nullable = false)
    private int studentId;

    public GroupStudentPK() {
    }

    public GroupStudentPK(int groupId, int studentId) {
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

    @Override
    public String toString() {
        return "GroupStudentPK{" +
                "groupId=" + groupId +
                ", studentId=" + studentId +
                '}';
    }
}
