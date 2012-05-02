// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankDao.java

package com.virusyang.newsec;


// Referenced classes of package bigbank:
//			Account

public interface BankDao
{

	public abstract Account readAccount(Long long1);

	public abstract void createOrUpdateAccount(Account account);

	public abstract Account[] findAccounts();
}
