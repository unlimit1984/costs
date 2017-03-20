package com.javapro.costs.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Vladimir on 20.03.2017.
 */
public class Purshase {
    Integer id;
    BigDecimal money;
    LocalDate createdDate;
    String category;
    String comment;
}
