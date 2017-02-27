package com.test.mvc.boimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.mvc.bo.StockBo;
import com.test.mvc.dao.StockDao;
import com.test.mvc.model.Stock;
@Service
public class StockBoImpl implements StockBo{

	StockDao stockDao;
	
	
	public void setStockDao(StockDao stockDao){
		this.stockDao=stockDao;
	}
	
	@Override
	@Transactional
	public void add(Stock stock) {
		// TODO Auto-generated method stub
		stockDao.add(stock);
	}

	@Override
	@Transactional
	public void delete(Stock stock) {
		// TODO Auto-generated method stub
		stockDao.delete(stock);
	}

	@Override
	public void update(Stock stock) {
		// TODO Auto-generated method stub
		stockDao.update(stock);
	}

	@Override
	@Transactional
	public String[] findAllName() {
		// TODO Auto-generated method stub
		return stockDao.findAllName();
	}

	@Override
	@Transactional
	public void delete() {
		// TODO Auto-generated method stub
		stockDao.delete();
	}

	@Override
	@Transactional
	public Stock findByName(String stockName) {
		// TODO Auto-generated method stub
		return stockDao.findByName(stockName);
	}

	@Override
	@Transactional
	public Stock[] findAllMember() {
		// TODO Auto-generated method stub
		return stockDao.findAllMember();
	}

}
