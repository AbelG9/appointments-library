package com.codigo.appointmentslibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public class Audit {
    @Column(name="user_created", length = 45, nullable = false)
    private String userCreated;
    @Column(name="date_created", nullable = false)
    private Timestamp dateCreated;
    @Column(name="user_modified",length = 45)
    private String userModified;
    @Column(name="date_modified")
    private Timestamp dateModified;
    @Column(name="user_deleted",length = 45)
    private String userDeleted;
    @Column(name="date_deleted")
    private Timestamp dateDeleted;
}
