package com.javapro.costs.service;

import com.javapro.costs.model.Purchase;
import com.javapro.costs.util.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Vladimir_Vysokomorny on 28-Jun-17.
 */
public interface PurchaseService {
  Purchase get(long id) throws NotFoundException;

  Purchase save(Purchase purchase) throws NotFoundException;

  void delete(long id) throws NotFoundException;

  List<Purchase> getAll();

  Page<Purchase> getAllPageable(Pageable pageable);

  List<Purchase> getBetweenDateTimes(LocalDate start, LocalDate end);
}
