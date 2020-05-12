package com.web.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.account.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {
	
	@Query(value = "select a from Account a where a.owner = ?1 order by a.accountNumber")
	public Account getByCondition(String acctName);	
	
	
	
}
