package com.kameleoon.test.model.dto;

import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "quote")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
    private String name;

    @Column(name = "comm")
    private String comment;


    @ManyToOne (optional=true, cascade=CascadeType.REFRESH)
    @JoinColumn (name="create_user")
    @NonNull
    private User createUser;

    @Column(name = "create_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @NonNull
    private OffsetDateTime createDate;

    @ManyToOne (optional=true, cascade=CascadeType.REFRESH)
    @JoinColumn (name = "change_user", nullable = true)

    private User changeUser;

    @Column(name = "change_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime changeDate;

    @OneToMany (mappedBy="quote", fetch=FetchType.EAGER)
    private List<QuoteValue> quoteValues;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

       public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

     public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public User getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(User changeUser) {
        this.changeUser = changeUser;
    }

   public OffsetDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(OffsetDateTime changeDate) {
        this.changeDate = changeDate;
    }

     public List<QuoteValue> getQuoteValues() {
        return quoteValues;
    }

    public void setQuoteValues(List<QuoteValue> quoteValues) {
        this.quoteValues = quoteValues;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", name='" + name + '\'' +
               ", comment='" + comment + '\'' +
                 ", createUser=" + createUser +
                ", createDate=" + createDate +
                ", changeUser=" + (changeUser == null ? "Change user not set." : changeUser)+
                                ", changeDate=" + (changeDate == null ? "Change date not set": changeDate)+
                ", quote values size" +(quoteValues == null ? "Qoute values is null" : quoteValues.size()) +
                '}';
    }
}
