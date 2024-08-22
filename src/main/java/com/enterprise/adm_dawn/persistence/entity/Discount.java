package com.enterprise.adm_dawn.persistence.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;
    private int discountPercentage;

    @Column(name = "discount_title")
    private String discountTitle;

    @Temporal(value = TemporalType.DATE)
    private Date startDate;

    @Temporal(value = TemporalType.DATE)
    private Date endDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timestamp;

    public Discount(
        int discountPercentage, 
        String discountTitle, 
        Date startDate, 
        Date endDate, 
        Date timestamp
    ) {
        this.discountPercentage = discountPercentage;
        this.discountTitle = discountTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timestamp = timestamp;
    }
}
