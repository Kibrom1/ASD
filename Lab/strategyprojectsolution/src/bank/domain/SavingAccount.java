package bank.domain;

import java.util.Date;



public class SavingAccount extends Account{

	public SavingAccount(long accountnr) {
		super(accountnr);
	}

	public void addInterest(){
		System.out.println("AddInterest on SavingAccount");
		System.out.println("Old balance = "+getBalance());
		double interest =interestStrategy.computeInterest(getBalance());
		AccountEntry entry = new AccountEntry(new Date(), interest, "interest", "", "");
		entryList.add(entry);
		System.out.println("New balance = "+getBalance());
	}
}
