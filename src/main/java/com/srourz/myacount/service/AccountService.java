package com.srourz.myacount.service;

import com.srourz.myacount.domain.Account;
import com.srourz.myacount.exception.BusinessException;

public interface AccountService {
	
	/**
	 * withdrawal an amount from the account
	 * @param account
	 * @param amount
	 * @throws BusinessException
	 */
	public void withdrawal(Account account, Double amount) throws BusinessException;
	
	/**
	 * return the statement details
	 * @param account
	 * @return
	 */
	public String displayStatement(Account account);
}
