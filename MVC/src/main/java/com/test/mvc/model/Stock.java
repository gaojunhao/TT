package com.test.mvc.model;

public class Stock {
public Stock(){
    	
    }
public Stock(String stockName){
    	this.StockName=stockName;
}

private Long StockId;
public Long getStockId(){
	return StockId;
}
public void setStockId(Long stockId){
	this.StockId=stockId;
}

private String StockName;
public String getStockName(){
	return StockName;
}
public void setStockName(String StockName){
	this.StockName=StockName;
}
}
