package com.kameleoon.test.model.dto;

import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "quote_values")
public class QuoteValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=true, cascade= CascadeType.REFRESH)
    @JoinColumn(name = "quote")
    private Quote quote;
    private float value;
    @Column(name = "value_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @NonNull
    private OffsetDateTime valueDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public OffsetDateTime getValueDate() {
        return valueDate;
    }

    public void setValueDate(OffsetDateTime valueDate) {
        this.valueDate = valueDate;
    }

    @Override
    public String toString() {
        return "QuoteValue{" +
                "id=" + id +
                ", quote=" + quote +
                ", value=" + value +
                ", valueDate=" + valueDate +
                '}';
    }
}
