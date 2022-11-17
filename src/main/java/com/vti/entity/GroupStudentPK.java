package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GroupStudentPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
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
