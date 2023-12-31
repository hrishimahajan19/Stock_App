package com.geekster.StockApp.service;

import com.geekster.StockApp.model.Stock;
import com.geekster.StockApp.model.StockType;
import com.geekster.StockApp.repository.IStockRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    IStockRepo stockRepo;
    public List<Stock> getAllStocks() {
        return (List<Stock>) stockRepo.findAll();
    }

    public String addStocks(List<Stock> stockList) {
        stockRepo.saveAll(stockList);
        return "Stocks Added";
    }

    public String stockDeleteById(Long id) {
        stockRepo.deleteById(id);
        return "Stock removed";
    }

    public List<Stock> getStocksByTypePriceDescSorted(StockType type) {
        return stockRepo.findByStockTypeOrderByStockPriceDesc(type);

   }

    public List<Stock> getStocksBirthTimeDesc() {
        return stockRepo.findByOrderByStockBirthTimeStamp();
    }
    @Transactional
    public void updateStocksByType(StockType type, Float hike) {
         stockRepo.updateStocksByType(type.name() ,hike);
    }
}
