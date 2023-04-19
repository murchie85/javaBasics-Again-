


public class BankAccount{
	private double balance;
	private String accountNumber;

	public BankAccount(double balance, String accountNumber){
		this.balance       = balance;
		this.accountNumber = accountNumber;
	}


	public void deposit(double amount){
		this.balance += amount;
	}

	public void withdraw(double amount){
		this.balance -= amount; 
	}

	public double getBalance(){
		return this.balance;
	}

	public String getAccountNumber(){
		return this.accountNumber;
	}

}

