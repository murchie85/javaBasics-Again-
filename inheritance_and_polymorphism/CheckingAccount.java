

public class CheckingAccount extends BankAccount{
	public double overdraftLimit;

	// you HAVE TO construct all parent variables even if you don't use them 
	public CheckingAccount(double balance, String accountNumber, double overdraftLimit){
		super(balance, accountNumber);
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public void withdraw(double amount){
		double balance = getBalance();
		if(balance-amount >= overdraftLimit){
			super.withdraw(amount);
		} else{
			System.out.println("withdrawal Denied: Exceeds overdraftLimit.");
		}
	}
}