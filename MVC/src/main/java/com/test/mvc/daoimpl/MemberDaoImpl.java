package com.test.mvc.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.test.mvc.dao.MemberDao;
import com.test.mvc.model.MemberInfo;

public class MemberDaoImpl implements MemberDao{

	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void add(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		getCurrentSession().save(memberInfo);
	}

	@Override
	public void delete(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		getCurrentSession().delete(memberInfo);
	}

	@Override
	public String[] find() {
		// TODO Auto-generated method stub
		Query query=getCurrentSession().createQuery("from MemberInfo");
		List<MemberInfo> memberInfos=query.getResultList();
		int size=memberInfos.size();
		String[] memberAllInfo=new String[size];
		int num=0;
		for (MemberInfo memberInfo : memberInfos) {
			memberAllInfo[num++]=memberInfo.getMemberFact();
		}
		return memberAllInfo;
	}
	@Override
	public int countRecord() {
		// TODO Auto-generated method stub
		Query query=getCurrentSession().createQuery("from MemberInfo");
		List<MemberInfo> memberInfos=query.getResultList();
		return memberInfos.size();
	}
	@Override
	public MemberInfo[] findAllInfo() {
		// TODO Auto-generated method stub
		Query query=getCurrentSession().createQuery("from MemberInfo");
		List<MemberInfo> memberInfos=query.getResultList();
		MemberInfo[] memberInfo=(MemberInfo[])memberInfos.toArray(new MemberInfo[memberInfos.size()]);
		return memberInfo;
	}

}
