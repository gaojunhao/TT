package com.test.mvc.bo;

import com.test.mvc.model.MemberInfo;
import com.test.mvc.model.ParterInfo;

public interface MemberBo {
public void add(MemberInfo memberInfo);
public void delete(MemberInfo memberInfo);
public ParterInfo[] find();
public int countRecord();
public MemberInfo[] findAllInfo();
}
