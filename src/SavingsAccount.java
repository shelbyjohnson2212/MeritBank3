import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;


public class SavingsAccount extends BankAccount {
		//don't name variable with a cap letter//
			public double balance;
			public final double interestRate = 0.01;
			
		//constructor method//
			public SavingsAccount(double openingBalance, double interestRate){
				super(openingBalance, interestRate);
			}
			
			public SavingsAccount(double openingSavingsBalance) {
				super(openingSavingsBalance);
			}
			public void accountOpenedOn(String simpleDateFormat(dd/MM/yyyy)) {
				super(accountOpenedOn);
				
			}
			/*
			double getInterestRate(){
				return interestRate;
			}
			
			double getBalance(){
				return balance;
			}
			
			boolean deposit(double amount){
				if(amount < 0) {
					return false;	
					} 
					else { 
						balance += amount;
					}
					return true;
			}
			
			boolean withdraw(double amount){
			//if the amount is less than zero it is false//
				if(amount < 0 || amount > balance) {
					return false;
				}
				else {
					//sub amount from balance - short hand same as: balance = balance - amount 
					balance -= amount;
				}
				return true;
			}
			
			double futureValue(int years){
				double futureValue = balance* Math.pow((1+ interestRate),years);
				return futureValue;
			}
	*/
			@Override public String toString(){
				return "Savings Account Balance: " + getBalance() + "\n"
						+ "Interest Rate: " + getInterestRate() + '\n'
						+ "Future Balance: " + futureValue(3);
			}
			
			
			
			static SavingAccount readFromString(String accountData) {
				String [] holding = accountData.split(",");
				SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy);
				long accountNumber = Long.parseLong(holding [0]);
				double balance = Double.parseDouble(holding[1]);
				double interrestRate = Double.parseDouble(holding[2]);
				Date accountOpenOn = date.parse(holding[3]);
				return new SavingsAccount(accountNumber, balance, interestRate, accountOpenedOn);
				
				
			}
	}
	


