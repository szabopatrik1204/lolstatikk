package com.patrik.lolstatikk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "properties")
public class PropertiesEntity {

    @Id
    private String key;

    private String value;

    private LocalDateTime updated;

}
