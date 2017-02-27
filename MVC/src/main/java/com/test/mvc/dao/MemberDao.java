package com.test.mvc.dao;

import com.test.mvc.model.MemberInfo;

public interface MemberDao {
public void add(MemberInfo memberInfo);
public void delete(MemberInfo memberInfo);
public String[] find();
public int countRecord();
public MemberInfo[] findAllInfo();
}
