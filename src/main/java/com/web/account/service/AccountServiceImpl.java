package com.web.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.web.account.dao.AccountDao;
import com.web.account.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Override
	public Account save(Account account) {
		Account account1 = accountDao.save(account);
		return account1;
	}

	@Override
	public List<Account> saveAll(List<Account> listAccount) {
		List<Account> accountList = accountDao.saveAll(listAccount);
		return accountList;
	}

	@Override
	public Account getAccount(Integer accountNumber) {
		return accountDao.getOne(new Integer(accountNumber));
	}

	@Override
	public List<Account> getAllAccount() {
		return accountDao.findAll();
	}

	@Override
	public Account updateAccount(Account acct) {
		acct = accountDao.save(acct);
		return acct;
	}

	@Override
	public String deleteAccount(Integer acctNo) {
		accountDao.deleteById(acctNo);
		
		return "AcctNo"+ acctNo + " Deleted successfully" ;
	}
	

	@Override
	public String deleteAllAccount(List<Integer> acctNoList) {
		for(Integer i:acctNoList)
		{
			accountDao.deleteById(i);
		} 
		return "All account deleted successfully";
	}

	@Override
	public Account getByCondition(String acctName) {
		return accountDao.getByCondition(acctName);
	}
	
	
	

}
