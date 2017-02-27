package com.test.mvc.model;

public class ParterInfo {
public String name;
public int[] votes=new int[12];
public String adviceInfo;
public ParterInfo(String name){
	this.name=name;
	for(int i=0;i<votes.length;i++){
		votes[i]=0;
	}
	this.adviceInfo="";
}
public String getName(){
	return name;
}
public void setName(String name){
	this.name=name;
}
public int[] getVotes(){
	return votes;
}
public void setVotes(int[] votes){
	this.votes=votes;
}
public String getAdviceInfo(){
	return adviceInfo;
}
public void setAdviceInfo(String adviceInfo){
	this.adviceInfo=adviceInfo;
}
}
