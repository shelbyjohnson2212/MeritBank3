
public class CDOffering {
	double interestRate;
	static int terms;
	
	public CDOffering(int terms, double interestRate){
		this.terms = terms;
		this.interestRate = interestRate;
	}

	int getTerm(){
		return terms;
	}
	
	double getInterestRate(){
		return interestRate;
	}
	
	static CDOffering readFromString(String cdOfferingDataString) {
		String[] holding =cdOfferingDataString.split(",");
		int term = Integer.parseInt(holding[0]);
		double interestRate = Double.parseDouble(holding[1]);
		return new CDOffering(terms, interestRate);	
	}

	public String writeToString() {
		StringBuilder cdOfferingData = new StringBuilder();
		cdOfferingData.append(terms).append(",");
		cdOfferingData.append(interestRate);
		return cdOfferingData.toString();
	}
}


