package com.test.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.mvc.bo.MemberBo;
import com.test.mvc.bo.StockBo;
import com.test.mvc.model.MemberInfo;
import com.test.mvc.model.ParterInfo;
import com.test.mvc.model.Stock;

@Controller
public class helloworld {

	public StockBo stockBo;
	public MemberBo memberBo;
	public Stock stock;
	public ParterInfo parterInfo;
	public MemberInfo memberInfo;
	public void setStockBo(StockBo stockBo){
		this.stockBo=stockBo;
	}
	
	public void setStock(Stock stock){
		this.stock=stock;
	}
	
	public void setMemberBo(MemberBo memberBo){
		this.memberBo=memberBo;
	}
	public void setMemberInfo(MemberInfo memberInfo){
		this.memberInfo=memberInfo;
	}
	public void setParterInfo(ParterInfo parterInfo){
		this.parterInfo=parterInfo;
	}
	public ModelAndView model=new ModelAndView("logIn");
	
	@RequestMapping(value="/getPer",method=RequestMethod.POST)
	@ResponseBody
	public String getPer(HttpServletRequest request) throws Exception{
		JSONObject backData = new JSONObject();
		backData.put("names",stockBo.findAllName());
		return backData.toString();
	}
	@RequestMapping(value="/sendData",method=RequestMethod.POST)
	@ResponseBody
	public String sendData(@RequestBody String request) throws Exception{
		memberInfo=new MemberInfo(request);
		memberBo.add(memberInfo);
		JSONObject backData = new JSONObject();
		backData.put("states","ok");
		return backData.toString();
	}
	@RequestMapping(value="/getResult",method=RequestMethod.POST)
	@ResponseBody
	public String getResult() throws Exception{
		ParterInfo[] parterInfos=memberBo.find();
		JSONArray backData=new JSONArray();
		int num=0;
		for (ParterInfo parterInfo : parterInfos) {
			JSONObject subData = new JSONObject();
			subData.put("name",parterInfo.getName());
			subData.put("votes",parterInfo.getVotes());
			subData.put("advices",parterInfo.getAdviceInfo());
			backData.put(num++, subData);
		}
//		backData.put("AllInfo",parterInfos);
		System.out.println(backData);
		return backData.toString();
	}
	@RequestMapping(value="/getRecord",method=RequestMethod.POST)
	@ResponseBody
	public Integer getRecord(){
		return memberBo.countRecord();
	}
	@RequestMapping(value="/clearRecord",method=RequestMethod.POST)
	@ResponseBody
	public String clearRecord(){
		MemberInfo[] memberInfos=memberBo.findAllInfo();
		for (MemberInfo memberInfo : memberInfos) {
			memberBo.delete(memberInfo);
		}
		return "已删除所有记录！";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(HttpServletRequest request){
		String name=request.getParameter("name");
        Stock stock=new Stock(name);
        stockBo.add(stock);
		return "ok"; 
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request){
		String name=request.getParameter("name");
        Stock stock=stockBo.findByName(name);
        stockBo.delete(stock);
		return "ok"; 
	}
	@RequestMapping(value="/clearName",method=RequestMethod.POST)
	@ResponseBody
	public String clearName(){
        Stock[] stocks=stockBo.findAllMember();
        for (Stock stock : stocks) {
        	stockBo.delete(stock);
		}
		return "ok"; 
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request){
		String StockCode=request.getParameter("StockCode");
		String StockName=request.getParameter("StockName");
//		stock.setStockCode(StockCode);
//		stock.setStockName(StockName);
//		stockBo.update(stock);
//		
//		model.addObject("stock", stock);

		return model; 
	}
	
	@RequestMapping(value="/findByName",method=RequestMethod.POST)
	public ModelAndView findByName(HttpServletRequest request){
		String StockCode=request.getParameter("StockCode");
		String StockName=request.getParameter("StockName");
//		stock.setStockCode(StockCode);
//		stock.setStockName(StockName);
//		stockBo.findByName(StockName);
//		
//		model.addObject("stock", stock);

		return model; 
	}
	
}
