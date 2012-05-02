// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankDaoStub.java

package com.virusyang.newsec;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package bigbank:
//			Account, BankDao

public class BankDaoStub
	implements BankDao
{

	private long id;
	private final Map accounts = new HashMap();

	public BankDaoStub()
	{
		id = 0L;
	}

	public void createOrUpdateAccount(Account account)
	{
		if (account.getId() == -1L)
		{
			id++;
			account.setId(id);
		}
		accounts.put(new Long(account.getId()), account);
		System.out.println((new StringBuilder()).append("SAVE: ").append(account).toString());
	}

	public Account[] findAccounts()
	{
		Account accounts[] = (Account[])this.accounts.values().toArray(new Account[0]);
		System.out.println((new StringBuilder()).append("Returning ").append(accounts.length).append(" account(s):").toString());
		Account arr$[] = accounts;
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++)
		{
			Account account = arr$[i$];
			System.out.println((new StringBuilder()).append(" > ").append(account).toString());
		}

		return accounts;
	}

	public Account readAccount(Long id)
	{
		return (Account)accounts.get(id);
	}
}
