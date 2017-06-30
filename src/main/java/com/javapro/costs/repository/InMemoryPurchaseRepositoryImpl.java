package com.javapro.costs.repository;

import com.javapro.costs.model.Purchase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by Vladimir_Vysokomorny on 29-Jun-17.
 */
public class InMemoryPurchaseRepositoryImpl implements PurchaseRepository {

    private Map<Integer, Purchase> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Purchase get(int id) {
        return repository.get(id);
    }

    @Override
    public Purchase save(Purchase purchase) {
        if (purchase.isNew()) {
            purchase.setId(counter.getAndIncrement());
        }
        repository.put(purchase.getId(), purchase);
        return purchase;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public List<Purchase> getAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public List<Purchase> getBetween(LocalDate start, LocalDate end) {
        return repository.values().stream().filter(p ->
                start.compareTo(p.getCreatedDate()) >= 0 && end.compareTo(p.getCreatedDate()) <= 0).collect(Collectors.toList());
    }
}
