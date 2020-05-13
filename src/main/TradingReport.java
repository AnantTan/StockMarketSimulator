package main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import builders.CompaniesBuilderClass;
import builders.InvestorBuilderClass;

public class TradingReport {

	// LinkedHashMap preserves the ordering of elements in which they are inserted
	LinkedHashMap<String, Integer> highestNumberOfShares = new LinkedHashMap<>();
	LinkedHashMap<String, Integer> captialOfACompany = new LinkedHashMap<>();
	private Set<String> sharesKeySet,capitalKeySet	;
	private String[] sharesKeyArray,capitalKeyArray;
	int maxShareCount, minShareCount,maxCapitalCount,minCapitalCount;

	public TradingReport() {

	}

	public void calculateCapital()
	{
		HashMap<String, Integer> details = new HashMap<>();
		for (CompaniesBuilderClass company : Companies.copyOfCompaniesList) {
		
			details.put(company.getName(), (int) (company.getNumberOfSharesAtTheStart()*company.getPriceOfShares()));
		}
		 details.entrySet().stream().sorted(HashMap.Entry.comparingByValue(Comparator.reverseOrder()))
         .forEachOrdered(x -> captialOfACompany.put(x.getKey(), x.getValue()));

			capitalKeySet = captialOfACompany.keySet();

			/*
			 * Convert set to an array using the toArray method
			 */
			capitalKeyArray = capitalKeySet.toArray(new String[capitalKeySet.size()]);

			// get key for the specified index
			// String key = keyArray[0];
			
			System.out.println(captialOfACompany);
		
			showHighestCapital(capitalKeyArray[maxCapitalCount]);
			minCapitalCount = capitalKeyArray.length-1;
			System.out.println("sizeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee "+capitalKeyArray.length);
			showLowestCapital(capitalKeyArray[minCapitalCount]);
	}
	
	private void showHighestCapital(String key)
	{
		System.out.println("Name: \t\t" + key);
		System.out.println("Capital: \t" + captialOfACompany.get(key));

		if (captialOfACompany.get(key) == captialOfACompany.get(capitalKeyArray[maxCapitalCount + 1])) {
			maxCapitalCount++;
			showHighestCapital(capitalKeyArray[maxShareCount]);
		}
	}
	
	private void showLowestCapital(String key)
	{
		System.out.println("Name: \t\t" + key);
		System.out.println("Capital: \t" + captialOfACompany.get(key));

		if (captialOfACompany.get(key) == captialOfACompany.get(capitalKeyArray[minCapitalCount -1])) {
			minCapitalCount--;
			showLowestCapital(capitalKeyArray[minCapitalCount]);
		}
	}
	
	
	public void investorWithHighestNumberOfShares() {
		System.out.println("---------------------------------");

		HashMap<String, Integer> details = new HashMap<>();
		for (InvestorBuilderClass investor : Investors.copyOfInvestorsList) {

			details.put(investor.getName(), investor.numberOfsharesBought);
	}

		System.out.println("Wrong:" + details);

		
		// Use Comparator.reverseOrder() for reverse ordering
		// put all the elements sorted in the linkedHashmap
		 details.entrySet().stream().sorted(HashMap.Entry.comparingByValue(Comparator.reverseOrder()))
         .forEachOrdered(x -> highestNumberOfShares.put(x.getKey(), x.getValue()));

		System.out.println("Top " + highestNumberOfShares);

		sharesKeySet = highestNumberOfShares.keySet();

		/*
		 * Convert set to an array using the toArray method
		 */
		sharesKeyArray = sharesKeySet.toArray(new String[sharesKeySet.size()]);

		// get key for the specified index
		// String key = keyArray[0];
		showHighestNumberOfShares(sharesKeyArray[maxShareCount]);
		minShareCount = sharesKeyArray.length-1;
		System.out.println("sizeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee "+sharesKeyArray.length);
		showLowestNumberOfShares(sharesKeyArray[minShareCount]);
	}

	private void showHighestNumberOfShares(String key) {
		
		System.out.println("Name: \t\t\t" + key);
		System.out.println("Number of shares: \t" + highestNumberOfShares.get(key));

		if (highestNumberOfShares.get(key) == highestNumberOfShares.get(sharesKeyArray[maxShareCount + 1])) {
			maxShareCount++;
			showHighestNumberOfShares(sharesKeyArray[maxShareCount]);
		}
	}

	private void showLowestNumberOfShares(String key) {
		
		System.out.println("Name: \t\t\t" + key);
		System.out.println("Number of shares: \t" + highestNumberOfShares.get(key));

		if (highestNumberOfShares.get(key) == highestNumberOfShares.get(sharesKeyArray[minShareCount-1])) {
			minShareCount--;
			showLowestNumberOfShares(sharesKeyArray[minShareCount]);
		}
	}
}