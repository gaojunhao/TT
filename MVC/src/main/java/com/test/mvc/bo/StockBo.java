package com.test.mvc.bo;

import java.util.List;

import com.test.mvc.model.Stock;

public interface StockBo {
public void add(Stock stock);
public void delete(Stock stock);
public void delete();
public void update(Stock stock);
public String[] findAllName();
public Stock findByName(String stockName);
public Stock[] findAllMember();
}
