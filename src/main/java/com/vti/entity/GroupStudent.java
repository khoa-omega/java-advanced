package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "group_student")
public class GroupStudent {
    @EmbeddedId
    private GroupStudentPK pk;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    @MapsId(value = "group_id")
    private Group group;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    @MapsId(value = "student_id")
    private Student student;

    @Column(name = "joined_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime joinedAt;

    public void setPk(GroupStudentPK pk) {
        this.pk = pk;
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
}
