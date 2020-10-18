import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;

public class MeritBank {
		static long accountNumber;
		static AccountHolder[] accountHolders = new AccountHolder[0];
		static CDOffering[] CDOfferingsArray = new CDOffering[0];
		
	
		static void addAccountHolder(AccountHolder accountHolder) {
			AccountHolder[] temp = Arrays.copyOf(accountHolders, accountHolders.length + 1);
			accountHolders = temp;
			accountHolders[accountHolders.length-1] = accountHolder;
		}
		
		AccountHolder[] getAccountHolders(){
			return accountHolders;
		}
		
		CDOffering[] getCDOfferings() {
			return CDOfferingsArray;
		}
		
		static CDOffering getBestCDOffering(double depositAmount){
			double bestValue = 0.0;
			CDOffering bestOfferingAvailable = null;
			if(CDOfferingsArray == null) {
				return null;
			} else {
				for(CDOffering offering: CDOfferingsArray) {
					if(futureValue(depositAmount, offering.getInterestRate(), offering.getTerm()) > bestValue) {
						bestOfferingAvailable = offering;
						bestValue = futureValue(depositAmount, offering.getInterestRate(), offering.getTerm());
					}
				}
			}
			return bestOfferingAvailable;
			
		}
		
		static CDOffering getSecondBestCDOffering(double depositAmount){
			CDOffering secondBest = null;
			double bestValue = 0.0;
			CDOffering bestOfferingAvailable = null;
			if(CDOfferingsArray == null) {
				return null;
			} else {
				for(CDOffering offering: CDOfferingsArray) {
					if(futureValue(depositAmount, offering.getInterestRate(), offering.getTerm()) > bestValue) {
						secondBest = bestOfferingAvailable;
						bestOfferingAvailable = offering;
						bestValue = futureValue(depositAmount, offering.getInterestRate(), offering.getTerm());
					}
				}
			}
			return secondBest;
		}
		
		static void clearCDOfferings(){
			CDOfferingsArray = null;
		}
		
		static void setCDOfferings(CDOffering[] offerings){
			CDOfferingsArray = offerings;
		}
		
		static long getNextAccountNumber() {
			return accountNumber += 1;
		}
		
		static double totalBalances() {
			double totalBalance = 0.0;
			for(AccountHolder accountHolder: accountHolders) {
				totalBalance += accountHolder.getCombinedBalance();
			}
			return totalBalance;
		}
		
		static double futureValue(double presentValue, double interestRate, int term) {
			double futureValue = presentValue* Math.pow((1+ interestRate),term);
			return futureValue;
		}
		
		public static boolean readFromFile(String fileName) {
			CDOffering[] offering = new CDOffering[0];
			try {
					FileReader reader = new fileReader(fileName);
					BufferedReader bufferedReader = new BufferedReader(reader);
					Long accountNumber = Long.valueOf(bufferedReader.readLine());
					int holdOffer = Integer.valueOf(bufferedReader.readLine());
					for(int i = 0; i < holdOffer; i++) {
						offering = Arrays.copyOf(offering.length + 1);
						offering[offering.length - 1] = CDOffering.readFromString(bufferedReader.readLine());
					}
			}
		}
		
		static boolean writeToFile(String fileName) {
			
		}
		
		static AccountHolder[] sortAccountHOlders() {
			
		}
		
		static void setNextAccountNumber(long nextAccountNumber) {
			
		}
		
		
		
		
		
		
		
		
}

	



