package com.javapro.costs.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Vladimir on 20.03.2017.
 */
@Data
public class Purchase {
    Long id;
    double money;
    LocalDate createdDate;
    String category;
    String comment;

    public boolean isNew() {
        return id != null;
    }
}
