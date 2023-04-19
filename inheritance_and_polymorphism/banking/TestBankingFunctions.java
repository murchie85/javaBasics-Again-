

class TestBankingFunctions{
	public static void main(String[] args){
		
		SavingsAccount mySavings    = new SavingsAccount(100.00, "101231",0.50);
		CheckingAccount myCheckings = new CheckingAccount(200,"202010", -300);


		System.out.println("Depositing 20 from savings account " + mySavings.getAccountNumber() );
		mySavings.deposit(20);
		
		System.out.println("Withdrawing 20 from savings account " + mySavings.getAccountNumber() );
		mySavings.withdraw(20);

		System.out.println("Applying interest to " + mySavings.getAccountNumber() );
		mySavings.applyInterest();

		System.out.println("Balance for savings account " + mySavings.getAccountNumber()  + " is : " + mySavings.getBalance());



		System.out.println("Depositing 20 from checkings account " + myCheckings.getAccountNumber() );
		myCheckings.deposit(20);
		
		System.out.println("Withdrawing 20 from checkings account " + myCheckings.getAccountNumber() );
		myCheckings.withdraw(500);

		System.out.println("Withdrawing 20 from checkings account " + myCheckings.getAccountNumber() );
		myCheckings.withdraw(30);

		System.out.println("Balance for checkings account " + myCheckings.getAccountNumber()  + " is : " + myCheckings.getBalance());

		BankAccount[] accounts = new BankAccount[2];
		accounts[0]  = mySavings;
		accounts[1]  = myCheckings;

		for (BankAccount account: accounts){
			System.out.println("Account Number is " + account.getAccountNumber());
			System.out.println("Account Balance is " + account.getBalance());
		}



	}
}



