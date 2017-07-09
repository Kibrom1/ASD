package bank.observer;

import bank.domain.Customer;
import bank.pattern.*;

public class SMSSender implements IObserver{

	public void update(Customer customer,double balance){
		System.out.println("Account Balance changed SMS sent");
	}

}