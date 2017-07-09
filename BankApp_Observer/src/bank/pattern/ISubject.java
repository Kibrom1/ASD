package bank.pattern;


public interface ISubject{
	public void register(IObserver o);
	public void unregister(IObserver o);
	public void notifyIObserver();
    
}
