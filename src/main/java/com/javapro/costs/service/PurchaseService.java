package com.javapro.costs.service;

import com.javapro.costs.model.Purchase;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Vladimir_Vysokomorny on 28-Jun-17.
 */
public interface PurchaseService {
    Purchase get(int id);
    List<Purchase> getAll();
    List<Purchase> getBetweenDateTimes(LocalDateTime start, LocalDateTime end);
    Purchase update(Purchase newPurchase);
    //Purchase save(Purchase newPurshase);
    void delete(int id);
}
