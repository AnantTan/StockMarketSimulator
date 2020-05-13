package main;

import java.util.ArrayList;
import java.util.HashSet;

import builders.CompaniesBuilderClass;
import interfaces.CompanyAndInvestor;
import interfaces.ShareSoldListener;
import simulation.CreateDynamicData;

public class Companies extends CreateDynamicData implements CompanyAndInvestor, ShareSoldListener {

	private String companyName = "", uniqueID = "", orgType = "";
	private CompaniesBuilderClass company;
	private static ArrayList<CompaniesBuilderClass> companyList = new ArrayList<>();
	public static ArrayList<CompaniesBuilderClass> copyOfCompaniesList = new ArrayList<>();

	public Companies() {
	}

	@Override
	public void run() {

		int count = 0;
		while (count != 100) {
			name(3, 10);
			if (checkAvailablilityBeforeRegistering(companyName) == true) {
				orgType = getOrganisationType();// get type of organization from the pool
				companyName = companyName.concat(orgType);// get type of organization from the pool
				uniqueID();
				if (checkAvailablilityBeforeRegistering(uniqueID) == true) {
					register();
					count++;
				} else
					uniqueID();
			} else {
				name(3, 10);
			}
		}
		// printCompanies();
	}

	@Override
	public void uniqueID() {

		this.uniqueID = createComapnyUniqueID();
	}

	@Override
	public void name(int start, int end) {

		this.companyName = generateName(start, end);
	}

	@Override
	public void register() {

		company = new CompaniesBuilderClass.CompanyBuilder().uniqueID(uniqueID.concat(orgType)).name(companyName)
				.numbersOfShares(getNum(500, 1000)).priceOfShares(getNum(10, 100)).build();

		companyList.add(company);
		copyOfCompaniesList.add(company);
	}

	// double the price of the shares if 10 shares are sold
	@Override
	public void update(CompaniesBuilderClass company) {

		company.numberOfShares--;
		company.numberOfSharesSold++;
		// if total shares sold from this company = 10 double its price
		if (company.numberOfSharesSold == 10) {
			company.setPriceOfShares(company.getPriceOfShares() * 2);
			company.numberOfSharesSold = 0;
		}
	}

	public void reducePriceOfShares(HashSet<CompaniesBuilderClass> companies) {
		for (CompaniesBuilderClass companyObj : companyList) {

			// if a company is not present in the set then reduce its price
			if (companies.add(companyObj)) {
				double reducedPrice = (companyObj.getPriceOfShares() * 2) / 100;
				companyObj.setPriceOfShares(companyObj.getPriceOfShares() - reducedPrice);
			}
		}
	}

	public ArrayList<CompaniesBuilderClass> getCompanyList() {
		return companyList;
	}

	@SuppressWarnings("unused")
	private void printCompanies() {

		int i = 1;
		for (CompaniesBuilderClass builderClass : companyList) {

			System.out.println("ID:\t" + builderClass.getUniqueID());
			System.out.println("Name:\t" + builderClass.getName());
			System.out.println("Number of share:\t" + builderClass.getNumberOfShares());
			System.out.println("Price of shares:\t" + builderClass.getPriceOfShares());
			System.out.println("Number of Companies= " + i);
			System.out.println();
			i++;
		}
	}
}