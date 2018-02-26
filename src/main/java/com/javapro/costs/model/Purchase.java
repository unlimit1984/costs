package com.javapro.costs.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Vladimir on 20.03.2017.
 */
@Data
@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue
    Long id;

    @Column
    double money;

    @Column
    LocalDate createdDate;

    @Column
    String category;

    @Column
    String comment;

    public Purchase() {
    }

    public boolean isNew() {
        return id != null;
    }
}
