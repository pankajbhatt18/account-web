package com.web.account.service;

import java.util.List;

import com.web.account.entity.Account;

public interface AccountService {

	public Account save(Account account); 
	public List<Account> saveAll(List<Account> listAccount);
	public Account getAccount(Integer accountNumber);
	public List<Account> getAllAccount();
	public Account updateAccount(Account acct);
	public String deleteAccount(Integer acctNo);
	public String deleteAllAccount(List<Integer> acctNoList);
	public Account getByCondition(String AcctName);
}
