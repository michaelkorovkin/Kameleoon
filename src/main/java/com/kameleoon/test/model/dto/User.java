package com.kameleoon.test.model.dto;

import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "kameleoon_user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "create_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @NonNull
    private OffsetDateTime createDate;

    @Column(name = "change_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @NonNull
    private OffsetDateTime changeDate;
    @Column(name = "comm")
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public OffsetDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(OffsetDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", createDate=" + createDate +
                ", changeDate=" + (changeDate == null ? "Not defined" : changeDate) +
                ", comment='" + comment + '\'' +
                '}';
    }
}
