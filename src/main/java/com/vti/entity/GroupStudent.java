package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "group_student")
@IdClass(value = GroupStudentPK.class)
public class GroupStudent {
    @Id
    private int groupId;

    @Id
    private int studentId;

    @Column(name = "joined_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime joinedAt;

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "GroupStudent{" +
                "groupId=" + groupId +
                ", studentId=" + studentId +
                ", joinedAt=" + joinedAt +
                '}';
    }
}
