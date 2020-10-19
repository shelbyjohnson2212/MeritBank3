public class CheckingAccount extends BankAccount {
	public double balance;
	public final double interestRate = 0.0001;
	
	public CheckingAccount(double openingBalance, double interestRate){
		super(openingBalance, interestRate);
	}
	
	public CheckingAccount(long accountNumber, double openingBalance, double interestRate){
		super(accountNumber, openingBalance, interestRate);
		
	}
	
	public CheckingAccount(double openingCheckingBalance) {
		super(openingCheckingBalance);
	}
	public boolean withdraw(double amount) {
		if(amount <= super.getBalance() && amount > 0) {
			this.balance = balance - amount;
			System.out.println("Withdrawn amount: " + amount);
			System.out.println("Remaining balance: " + balance);
			return true;
		}
		return false;
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			this.balance = balance + amount;
			System.out.println("Deposited amount: " + amount);
			System.out.println("Total balance: " + balance);
			return true;
		}
		return false;		
	}

	public String toString() {
		return  "Checking Account Balance: $" + getBalance() + "\n" + 
				"Checking Account Interest Rate: " + getInterestRate() + "\n" + 
				"Checking Account Balance in 3 years: $" + futureValue(3);
		
	}
	
	public String toString() {
		return "Checking Account Balance: " + getBalance() + "\n"
				+ "Interest Rate is: " + getInterestRate() + '\n'
				+ "Future Balance is: " + futureValue(3);
	}
	
	static CheckingAccount readFromString(String accountData) {
		String [] holding = accountData.split(",");
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		//[0] is accountNumber, [1] is balance, [2] is interestRate, date is [3] which is SimpleDate
		long accountNumber = Long.parseLong(holding[0]);
		double balance = Double.parseDouble(holding[1]);
		double interestRate = Double.parseDouble(holding[2]);
		Date accountOpenedOn = date.parse(holding[3]);
		CheckingAccount newCheckingAccount = new CheckingAccount(accountNumber, balance, interestRate, accountOpenedOn);
		return newCheckingAccount;
	}
	
	
	
	
	
	
}

