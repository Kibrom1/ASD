package bank.domain;

import java.util.Date;


public class CheckingAccount extends Account{

	public CheckingAccount(long accountnr) {
		super(accountnr);
	}

	public void addInterest(){
		System.out.println("AddInterest on CheckingsAccount");
		System.out.println("Old balance = "+getBalance());
		double interest =interestStrategy.computeInterest(getBalance());
		AccountEntry entry = new AccountEntry(new Date(), interest, "interest", "", "");
		entryList.add(entry);
		System.out.println("New balance = "+getBalance());
	}

}
