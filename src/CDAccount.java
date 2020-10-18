import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class CDAccount{
	
	private double balance;
	private long accountNumber;
	CDOffering offerings;
	Date date;
	
	public CDAccount(CDOffering offerings, double balance) {
		this.offerings = offerings;
		this.date = new Date();
		this.balance = balance;
		this.accountNumber = MeritBank.getNextAccountNumber();
	}
		
	public CDAccount(long accountNumber2, double balance2, double interestRate, Date accountOpenedOn, int terms) {
		// TODO Auto-generated constructor stub
	}

	public double getBalance(){
		return balance;
	}
	
	java.util.Date getStartDate(){
		return date;
	}
	
	public long getAccountNumber(){
		return accountNumber;
		
	}
	
	int getTerm() {
		return offerings.getTerm();
	}
	
	double getInterestRate() {
		return offerings.getInterestRate();
	}
		
	public double futureValue(){
		double futureValue = balance* Math.pow((1+ getInterestRate()),getTerm());
		return futureValue;
	}
	
	
	
	static CDAccount readFromString(String accountData) {
		String[] holding = accountData.split(",");
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		long accountNumber = Long.parseLong(holding[0]);
		double balance = Double.parseDouble(holding[1]);
		double interestRate = Double.parseDouble(holding[2]);
		Date accountOpenedOn = date.parse(holding[3]);
		int terms = Integer.parseInt(holding[4]);
		CDAccount newCDAccount = new CDAccount(accountNumber, balance, interestRate, accountOpenedOn, terms);
		return newCDAccount;
		
		
	}

	public String writeToString() {
		StringBuilder override = new StringBuilder();
		override.append(writeToString()).append(",");
		return override.toString();
	
	}
}


