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
    private GroupStudentPK id;

    @Column(name = "joined_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime joinedAt;

    public GroupStudentPK getId() {
        return id;
    }

    public void setId(GroupStudentPK id) {
        this.id = id;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    @Override
    public String toString() {
        return "GroupStudent{" +
                "id=" + id +
                ", joinedAt=" + joinedAt +
                '}';
    }
}
