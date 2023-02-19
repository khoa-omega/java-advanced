package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "group_student")
public class GroupStudent {
    @EmbeddedId
    private GroupStudentPK pk;

    @Column(name = "joined_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime joinedAt;

    public void setPk(GroupStudentPK pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return "GroupStudent{" +
                "pk=" + pk +
                ", joinedAt=" + joinedAt +
                '}';
    }
}
