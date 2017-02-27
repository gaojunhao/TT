package com.test.mvc.boimpl;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;

import com.test.mvc.bo.MemberBo;
import com.test.mvc.bo.StockBo;
import com.test.mvc.dao.MemberDao;
import com.test.mvc.model.MemberInfo;
import com.test.mvc.model.ParterInfo;

public class MemberBoImpl implements MemberBo{

	public MemberDao memberDao;
	public StockBo stockBo;
	public void setMemberDao(MemberDao memberDao){
		this.memberDao=memberDao;
	}
	public void setStockBo(StockBo stockBo){
		this.stockBo=stockBo;
	}
	@Override
	@Transactional
	public void add(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		memberDao.add(memberInfo);
	}

	@Override
	@Transactional
	public void delete(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		memberDao.delete(memberInfo);
	}

	@Override
	@Transactional
	public ParterInfo[] find() {
		// TODO Auto-generated method stub
		String[] names=stockBo.findAllName();
		ParterInfo[] parterInfo=new ParterInfo[names.length];
		int num=0;
		for (String name : names) {
			parterInfo[num++]=new ParterInfo(name);
		}
		String[] Infos=memberDao.find();
		for (String Info : Infos) {
			try {
				JSONObject data = new JSONObject(Info);
				String beforeInStr=data.getString("beforeInStr");
				String afterInStr=data.getString("afterInStr");
				String conditionStr=data.getString("conditionStr");
				String satisfactionStr=data.getString("satisfactionStr");
				String badStr=data.getString("badStr");
				String[] beforeIn=splitMethod(beforeInStr);
				String[] afterIn=splitMethod(afterInStr);
				String[] condition=splitMethod(conditionStr);
				String[] satisfaction=splitMethod(satisfactionStr);
				String[] bad=splitMethod(badStr);
				for (int i=0;i<names.length;i++) {
					System.out.println(beforeIn[i]);
					if(beforeIn[i].equals("Perfect")){
						parterInfo[i].votes[0]++;
					}else if(beforeIn[i].equals("Good")){
						parterInfo[i].votes[1]++;
					}else{
						parterInfo[i].votes[2]++;
					}
					
					if(afterIn[i].equals("Perfect")){
						parterInfo[i].votes[3]++;
					}else if(afterIn[i].equals("Good")){
						parterInfo[i].votes[4]++;
					}else{
						parterInfo[i].votes[5]++;
					}
					
					if(condition[i].equals("Perfect")){
						parterInfo[i].votes[6]++;
					}else if(condition[i].equals("Good")){
						parterInfo[i].votes[7]++;
					}else{
						parterInfo[i].votes[8]++;
					}
					
					if(satisfaction[i].equals("Perfect")){
						parterInfo[i].votes[9]++;
					}else if(satisfaction[i].equals("Good")){
						parterInfo[i].votes[10]++;
					}else{
						parterInfo[i].votes[11]++;
					}
					
					parterInfo[i].adviceInfo+=bad[i];
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return parterInfo;
	}
	public String[] splitMethod(String t){
		String[] sp=t.split("\"");
	    String[] result=new String[sp.length/2];
	    for (int i=1,j=0;i<sp.length;i+=2,j++) {
			result[j]=sp[i];
		}
	    return result;
	}
	@Override
	@Transactional
	public int countRecord() {
		// TODO Auto-generated method stub
		return memberDao.countRecord();
	}
	@Override
	@Transactional
	public MemberInfo[] findAllInfo() {
		// TODO Auto-generated method stub
		return memberDao.findAllInfo();
	}
}
