// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Account.java

package com.virusyang.newsec;


public class Account
{

	private long id;
	private String holder;
	private double balance;
	private double overdraft;

	public Account(String holder)
	{
		id = -1L;
		overdraft = 100D;
		this.holder = holder;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getHolder()
	{
		return holder;
	}

	public void setHolder(String holder)
	{
		this.holder = holder;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public double getOverdraft()
	{
		return overdraft;
	}

	public void setOverdraft(double overdraft)
	{
		this.overdraft = overdraft;
	}

	public String toString()
	{
		return (new StringBuilder()).append("Account[id=").append(id).append(",balance=").append(balance).append(",holder=").append(holder).append(", overdraft=").append(overdraft).append("]").toString();
	}
}
