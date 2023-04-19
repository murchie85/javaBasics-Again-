

public class SavingsAccount extends BankAccount{
	public double interestRate;

	// you HAVE TO construct all parent variables even if you don't use them 
    public SavingsAccount(double balance, String accountNumber, double interestRate) {
        super(balance, accountNumber);
        this.interestRate = interestRate;
    }

	public void applyInterest(){
		double balance    = getBalance();
		double interest  =  balance * this.interestRate;
		deposit(interest);

	}
}


