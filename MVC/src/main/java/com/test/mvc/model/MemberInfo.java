package com.test.mvc.model;

public class MemberInfo {
public MemberInfo(){
	
}
public MemberInfo(String MemberFact){
	this.MemberFact=MemberFact;
}
public Long MemberId;
public void setMemberId(Long MemberId){
	this.MemberId=MemberId;
}
public Long getMemberId(){
	return MemberId;
}

public String MemberFact;
public void setMemberFact(String MemberFact){
	this.MemberFact=MemberFact;
}
public String getMemberFact(){
	return MemberFact;
}
}
