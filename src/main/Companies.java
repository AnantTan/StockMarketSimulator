package main;

import java.util.ArrayList;
import java.util.HashSet;

import builders.CompaniesBuilderClass;
import companyAndInvestor.CompanyAndInvestor;
import companyAndInvestor.ShareSoldListener;
import simulation.CreateDynamicData;

public class Companies extends CreateDynamicData implements CompanyAndInvestor, ShareSoldListener {

	private String companyName = "", uniqueID = "", orgType = "";
	private CompaniesBuilderClass company;
	public static ArrayList<CompaniesBuilderClass> companyList = new ArrayList<>();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		System.out.println("tast 1 started");

		int count = 0;
		while (count != 20) {
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
		System.out.println("///////////////////////////////////////////////////////////task 1 done");
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

//		company = new CompaniesBuilderClass.CompanyBuilder().uniqueID("c1").name("c1c")
//		.numbersOfShares(20).priceOfShares(700).build();
//		
//		companyList.add(company);
//		
//		company = new CompaniesBuilderClass.CompanyBuilder().uniqueID("c2").name("c2c")
//				.numbersOfShares(30).priceOfShares(600).build();
//		
//		companyList.add(company);
//		
//		company = new CompaniesBuilderClass.CompanyBuilder().uniqueID("c3").name("c3c")
//				.numbersOfShares(10).priceOfShares(1000).build();
//	
//		companyList.add(company);

		company = new CompaniesBuilderClass.CompanyBuilder().uniqueID(uniqueID.concat(orgType)).name(companyName)
				.numbersOfShares(getNum(500, 1000)).priceOfShares(getNum(10, 100)).build();

		companyList.add(company);

	}

	// double the price of the shares if 10 shares are sold
	@Override
	public void update(CompaniesBuilderClass company) {

		company.numberOfShares--;
		company.numberOfSharesSold++;
		if (company.numberOfSharesSold == 10) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 111Increase price"+company.getPriceOfshares());
			company.setPriceOfShares(company.getPriceOfshares() * 2);
			System.out.println("*********************************** 111Increase price"+company.getPriceOfshares());
			System.exit(0);
			
		}
	}
	
	public void reducePriceOfShares(HashSet<CompaniesBuilderClass> companies)
	{
		for (CompaniesBuilderClass companyObj : companyList) {
			
			//if a company is not present in the set reduce its price
			if(companies.add(companyObj)) {
				
				System.out.println("rrrrrrrrrrrrrrrrrrrr"+companyObj.getPriceOfshares());
				double reducedPrice = (companyObj.getPriceOfshares()*2)/100;
				System.out.println("reduced price "+reducedPrice);
				companyObj.setPriceOfShares(companyObj.getPriceOfshares()-reducedPrice);
				System.out.println("ttttttttttttttttttttttttt"+companyObj.getPriceOfshares());
			}
			
		}
	}

	public static ArrayList<CompaniesBuilderClass> getListOfCompanies() {
		return companyList;
	}

	private void printCompanies() {

		int i = 1;
		for (CompaniesBuilderClass builderClass : companyList) {

			System.out.println("ID:\t" + builderClass.getUniqueID());
			System.out.println("Name:\t" + builderClass.getName());
			System.out.println("Number of share:\t" + builderClass.getNumberOfShares());
			System.out.println("Price of shares:\t" + builderClass.getPriceOfshares());
			System.out.println("Number of Companies= " + i);
			System.out.println();
			i++;
		}
	}
}
