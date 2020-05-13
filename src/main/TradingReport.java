package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import builders.CompaniesBuilderClass;
import builders.InvestorBuilderClass;

public class TradingReport {

	// LinkedHashMap preserves the ordering of elements in which they are inserted
	private LinkedHashMap<String, Integer> highestNumberOfShares = new LinkedHashMap<>();
	private LinkedHashMap<String, Integer> captialOfACompany = new LinkedHashMap<>();
	private ArrayList<String> highestCapitalKeys = new ArrayList<>();
	private ArrayList<String> lowestCapitalKeys = new ArrayList<>();
	private ArrayList<String> highestSharesKeys = new ArrayList<>();
	private ArrayList<String> lowestSharesKeys = new ArrayList<>();
	private Set<String> sharesKeySet, capitalKeySet;
	private String[] sharesKeyArray, capitalKeyArray;
	int maxShareCount, minShareCount, maxCapitalCount, minCapitalCount;

	public TradingReport() {

		calculateCapital();
		calculateShares();
	}

	private void calculateCapital() {
		HashMap<String, Integer> details = new HashMap<>();
		for (CompaniesBuilderClass company : Companies.copyOfCompaniesList) {

			details.put(company.getUniqueID(), (int) (company.getNumberOfSharesAtTheStart() * company.getPriceOfShares()));
		}
		details.entrySet().stream().sorted(HashMap.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> captialOfACompany.put(x.getKey(), x.getValue()));

		capitalKeySet = captialOfACompany.keySet();

		// Convert set to an array using the toArray method
		capitalKeyArray = capitalKeySet.toArray(new String[capitalKeySet.size()]);

		// get key for the specified index
		// String key = keyArray[0];

		calculateHighestCapital(capitalKeyArray[maxCapitalCount]);
		minCapitalCount = capitalKeyArray.length - 1;
		calculateLowestCapital(capitalKeyArray[minCapitalCount]);
	}

	private void calculateHighestCapital(String key) {
		highestCapitalKeys.add(key);

		if (captialOfACompany.get(key) == captialOfACompany.get(capitalKeyArray[maxCapitalCount + 1])) {
			maxCapitalCount++;
			calculateHighestCapital(capitalKeyArray[maxShareCount]);
		}
	}

	private void calculateLowestCapital(String key) {
	
		lowestCapitalKeys.add(key);

		if (captialOfACompany.get(key) == captialOfACompany.get(capitalKeyArray[minCapitalCount - 1])) {
			minCapitalCount--;
			calculateLowestCapital(capitalKeyArray[minCapitalCount]);
		}
	}

	private void calculateShares() {

		HashMap<String, Integer> details = new HashMap<>();
		for (InvestorBuilderClass investor : Investors.copyOfInvestorsList) {

			details.put(String.valueOf(investor.getUniqueID()), investor.numberOfsharesBought);
		}

		// Use Comparator.reverseOrder() for reverse ordering
		// put all the elements sorted in the linkedHashmap
		details.entrySet().stream().sorted(HashMap.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> highestNumberOfShares.put(x.getKey(), x.getValue()));

		sharesKeySet = highestNumberOfShares.keySet();

		
		//Convert set to an array using the toArray method
		 
		sharesKeyArray = sharesKeySet.toArray(new String[sharesKeySet.size()]);

		// get key for the specified index
		// String key = keyArray[0];
		calculateHighestNumberOfShares(sharesKeyArray[maxShareCount]);
		minShareCount = sharesKeyArray.length - 1;
		calculateLowestNumberOfShares(sharesKeyArray[minShareCount]);
	}

	private void calculateHighestNumberOfShares(String key) {

		highestSharesKeys.add(key);

		if (highestNumberOfShares.get(key) == highestNumberOfShares.get(sharesKeyArray[maxShareCount + 1])) {
			maxShareCount++;
			calculateHighestNumberOfShares(sharesKeyArray[maxShareCount]);
		}
	}

	private void calculateLowestNumberOfShares(String key) {

		lowestSharesKeys.add(key);

		if (highestNumberOfShares.get(key) == highestNumberOfShares.get(sharesKeyArray[minShareCount - 1])) {
			minShareCount--;
			calculateLowestNumberOfShares(sharesKeyArray[minShareCount]);
		}
	}

	public final void showHighestCapital() {
		for (String str : highestCapitalKeys) {
			System.out.println("Name: \t\t" + str);
			System.out.println("Capital: \t" + captialOfACompany.get(str));
			System.out.println();
		}
	}

	public final void showLowestCapital() {
		for (String str : lowestCapitalKeys) {
			System.out.println("Name: \t\t" + str);
			System.out.println("Capital: \t" + captialOfACompany.get(str));
			System.out.println();
		}
	}

	public final void showHighestShares() {
		for (String str : highestSharesKeys) {
			System.out.println("Name: \t\t" + str);
			System.out.println("Capital: \t" + highestNumberOfShares.get(str));
			System.out.println();
		}
	}

	public final void showLowestShares() {
		for (String str : lowestSharesKeys) {
			System.out.println("Name: \t\t" + str);
			System.out.println("Capital: \t" + highestNumberOfShares.get(str));
			System.out.println();
		}
	}
}