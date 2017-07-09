package bank.domain;

import java.util.*;
import bank.pattern.*;

public class Account implements ISubject {
	long accountnumber;
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	Customer customer;
	private List<IObserver> observers;

	public Account(long accountnr) {
		this.accountnumber = accountnr;
		observers = new ArrayList<IObserver>();
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
		entryList.add(entry);

		notifyIObserver();
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		entryList.add(entry);

		notifyIObserver();
	}

	private void addEntry(AccountEntry entry) {
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, "" + toAccount.getAccountnumber(),
				toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, "" + toAccount.getAccountnumber(),
				toAccount.getCustomer().getName());
		entryList.add(fromEntry);
		toAccount.addEntry(toEntry);
		toAccount.deposit(amount);

		notifyIObserver();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	public void register(IObserver o) {
		observers.add(o);

	}

	public void unregister(IObserver o) {
		int observerIndex = observers.indexOf(o);
		System.out.println("Observer " + (observerIndex + 1) + "deleted");
		observers.remove(observerIndex);

	}

	public void notifyIObserver() {
		for (IObserver observer : observers) {
			observer.update(customer, getBalance());
		}

	}

}
