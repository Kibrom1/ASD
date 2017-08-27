package bank.dao;

import java.util.*;
import bank.domain.Account;

public class AccountDAOFactory{
	
	public Static IAccountDAO getAccountDAO() {
		return new AccountDAO();
	}
}
