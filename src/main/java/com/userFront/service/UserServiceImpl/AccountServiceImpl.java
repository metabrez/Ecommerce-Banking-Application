package com.userFront.service.UserServiceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userFront.dao.PrimaryAccountDao;
import com.userFront.dao.SavingsAccountDao;
import com.userFront.domain.PrimaryAccount;
import com.userFront.domain.SavingsAccount;
import com.userFront.service.AccountService;
import com.userFront.service.UserService;


@Service
public class AccountServiceImpl implements AccountService{
	private static int nextAccountNumber=11223145;
	@Autowired
	private PrimaryAccountDao primaryAccountDao;
	@Autowired
	private SavingsAccountDao savingsAccountDao;
	@Autowired
	private UserService userService;
	/*@Autowired
	private TransactionService transactionService;*/

	@Override
	public PrimaryAccount createPrimaryAccount() {
		PrimaryAccount primaryAccount=new PrimaryAccount();
		primaryAccount.setAccountBalance(new BigDecimal(0.0));
		primaryAccount.setAccountNumber(accountGen());
		primaryAccountDao.save(primaryAccount);
		
		return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
		
	}

	@Override
	public SavingsAccount createSavingsAccount() {
		SavingsAccount savingsAccount=new SavingsAccount();
		savingsAccount.setAccountBalance(new BigDecimal(0.0));
		savingsAccount.setAccountnumber(accountGen());
		savingsAccountDao.save(savingsAccount);
		return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountnumber());
		
		
	}
	
	private int accountGen() {
		
		return ++nextAccountNumber;
	}

}
