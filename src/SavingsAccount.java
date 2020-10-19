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
			
			public SavingsAccount(long accountNumber, double openingBalance, double interestRate, Date accountOpenOn) {
				super(accountNumber, openingBalance, interestRate, accountOpenOn);
			}
		
			public String toString(){
				return "Savings Account Balance: " + getBalance() + "\n"
						+ "Interest Rate: " + getInterestRate() + '\n'
						+ "Future Balance: " + futureValue(3);
			}
			
			
			
				public static SavingsAccount readFromString(String accountData)throws ParseException, NumberFormatException {
				String [] holding = accountData.split(",");
				SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
				//[0] is the accountNumber, [1] is the balance, [2] is the interestRate, date is [3] which is SimpleDate
				long accountNumber = Long.parseLong(holding [0]);
				double balance = Double.parseDouble(holding[1]);
				double interrestRate = Double.parseDouble(holding[2]);
				Date accountOpenOn = date.parse(holding[3]);
				
				return new SavingsAccount(accountNumber, balance, interestRate, accountOpenOn);
			}
	}
	













