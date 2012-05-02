// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SeedData.java

package com.virusyang.newsec;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

// Referenced classes of package bigbank:
//			Account, BankDao

public class SeedData
	implements InitializingBean
{

	private BankDao bankDao;

	public SeedData()
	{
	}

	public void afterPropertiesSet()
		throws Exception
	{
		Assert.notNull(bankDao);
		bankDao.createOrUpdateAccount(new Account("rod"));
		bankDao.createOrUpdateAccount(new Account("dianne"));
		bankDao.createOrUpdateAccount(new Account("scott"));
		bankDao.createOrUpdateAccount(new Account("peter"));
	}

	public void setBankDao(BankDao bankDao)
	{
		this.bankDao = bankDao;
	}
}
