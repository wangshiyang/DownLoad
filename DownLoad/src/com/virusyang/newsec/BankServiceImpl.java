// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankServiceImpl.java

package com.virusyang.newsec;

import org.springframework.util.Assert;

// Referenced classes of package bigbank:
//			BankService, BankDao, Account

public class BankServiceImpl
	implements BankService
{

	private final BankDao bankDao;

	public BankServiceImpl(BankDao bankDao)
	{
		Assert.notNull(bankDao);
		this.bankDao = bankDao;
	}

	public Account[] findAccounts()
	{
		return bankDao.findAccounts();
	}

	public Account post(Account account, double amount)
	{
		Assert.notNull(account);
		Account a = bankDao.readAccount(Long.valueOf(account.getId()));
		if (a == null)
		{
			throw new IllegalArgumentException("Couldn't find requested account");
		} else
		{
			a.setBalance(a.getBalance() + amount);
			bankDao.createOrUpdateAccount(a);
			return a;
		}
	}

	public Account readAccount(Long id)
	{
		return bankDao.readAccount(id);
	}
}
