package com.enterprise.adm_dawn.persistence.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private String imageTitle;
    private Double imageSize;

    // @Column(columnDefinition = "LONGBLOB")
    @Column(columnDefinition = "BYTEA")
    private byte[] imageSource;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateAdded;

    public Image(
        String imageTitle, 
        Double imageSize, 
        byte[] imageSource, 
        Date dateAdded
    ) {
        this.imageTitle = imageTitle;
        this.imageSize = imageSize;
        this.imageSource = imageSource;
        this.dateAdded = dateAdded;
    }
}
