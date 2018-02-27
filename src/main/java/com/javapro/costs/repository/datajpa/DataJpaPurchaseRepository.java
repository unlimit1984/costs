package com.javapro.costs.repository.datajpa;

import com.javapro.costs.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface DataJpaPurchaseRepository extends JpaRepository<Purchase, Serializable> {

//    @SuppressWarnings("JpaQlInspection")
//    @Query("SELECT p from Purchase p WHERE p.created_date BETWEEN :startDate AND :endDate ORDER BY p.created_date DESC")
//    List<Purchase> getBetween(@Param("startDate") LocalDate startDate, @Param("end") LocalDate endDate);
}
