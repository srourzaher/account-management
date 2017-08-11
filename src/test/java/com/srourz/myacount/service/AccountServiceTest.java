package com.srourz.myacount.service;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.srourz.myacount.domain.Account;
import com.srourz.myacount.exception.BusinessException;

public class AccountServiceTest extends TestCase{
	AccountService accountService = ServiceFactory.getAccountServiceInstance();
	
    @Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testSucessfullWithdrawal() throws BusinessException{
		Account account = new Account("Pierre Jean", 100d);
		accountService.withdrawal(account, 10d);
		assertEquals(90d, account.getBalance());
		assertTrue("the withdrawal transaction is token in charge", account.getStatement().size()==1);
	}

	@Test
	public void testFaildWithdrawal()  {
		Account account = new Account("Pierre Jean", 100d);
		try {
			accountService.withdrawal(account, 150d);
		} catch (BusinessException e) {
			 assert(e.getMessage().contains("you don't have sufficient credit"));
		}		
	}

}
