package com.test.mvc.daoimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mvc.dao.StockDao;
import com.test.mvc.model.Stock;
@Repository
public class StockDaoImpl implements StockDao{

	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void add(Stock stock) {
		// TODO Auto-generated method stub
		getCurrentSession().save(stock);
	}

	@Override
	public void delete(Stock stock) {
		// TODO Auto-generated method stub
		getCurrentSession().delete(stock);
//		System.out.println(stock.getStockName());
//		Session session=sessionFactory.openSession();
//		Transaction tx=session.beginTransaction();
//		try{
//		session.delete(stock);
//		tx.commit();
//		}catch(Exception e){
//		e.printStackTrace();
//		tx.rollback();
//		}finally{
//		session.close();
//		}
	}

	@Override
	public void update(Stock stock) {
		// TODO Auto-generated method stub
		getCurrentSession().update(stock);
	}

	@Override
	public String[] findAllName() {
		// TODO Auto-generated method stub
		Query query=getCurrentSession().createQuery("from Stock");
		List<Stock> stocks=query.getResultList();
		String[] stockName=new String[stocks.size()];
		int num=0;
		for (Stock stock : stocks) {
			stockName[num++]=stock.getStockName();
		}
		return stockName;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		getCurrentSession().delete("from Stock");
	}

	@Override
	public Stock findByName(String stockName) {
		// TODO Auto-generated method stub
		Query query=getCurrentSession().createQuery("from Stock where StockName=?");
		query.setParameter(0, stockName);
		Stock stock=(Stock)query.getResultList().get(0);
		return stock;
	}

	@Override
	public Stock[] findAllMember() {
		// TODO Auto-generated method stub
		Query query=getCurrentSession().createQuery("from Stock");
		List<Stock> stocks=query.getResultList();
		int size=stocks.size();
		Stock[] allStock=(Stock[])stocks.toArray(new Stock[size]);
		return allStock;
	}

}
