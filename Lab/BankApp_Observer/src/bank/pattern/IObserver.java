package bank.pattern;

import bank.domain.Customer;

public interface IObserver{
    public void update(Customer customer,double balance);
    
}
