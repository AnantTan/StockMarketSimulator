package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;

import builders.CompaniesBuilderClass;
import interfaces.CompanyAndInvestor;
import interfaces.ShareSoldListener;
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
		//printCompanies();
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

		company = new CompaniesBuilderClass.CompanyBuilder().uniqueID(uniqueID.concat(orgType)).name(companyName)
				.numbersOfShares(getNum(500, 1000)).priceOfShares(getNum(10, 100)).build();

		companyList.add(company);
	}

	// double the price of the shares if 10 shares are sold
	@Override
	public void update(CompaniesBuilderClass company) {

		company.numberOfShares--;
		company.numberOfSharesSold++;
		if (company.numberOfSharesSold == 10) /*&& !((company.getPriceOfShares()*2) >100))*/ {
			//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 111Increase price"+company.getNumberOfShares());
		company.setPriceOfShares(company.getPriceOfShares() * 2);
		company.numberOfSharesSold=0;
			//System.out.println("*********************************** 111Increase price"+company.getNumberOfShares());
			//System.exit(0);
		}
	}
	
	public static ArrayList<CompaniesBuilderClass> thisList = new ArrayList<>();
	
	public void reducePriceOfShares(HashSet<CompaniesBuilderClass> companies)
	{
		for (CompaniesBuilderClass companyObj : companyList) {
			
			//if a company is not present in the set then reduce its price
			if(companies.add(companyObj))/* && companyObj.getPriceOfShares()>10)*/ {
				
				if(companyObj.getPriceOfShares()>60 && companyObj.getPriceOfShares()<70)
				{
					thisList.add(companyObj);
				}
				else if(companyObj.getPriceOfShares()>40 && companyObj.getPriceOfShares()<500)
				{
					thisList.add(companyObj);
				}
				else if(companyObj.getPriceOfShares()>200 && companyObj.getPriceOfShares()<300)
				{
					thisList.add(companyObj);
				}
				else if(companyObj.getPriceOfShares()>0 && companyObj.getPriceOfShares()<10)
				{
					thisList.add(companyObj);
				}
				//System.out.println("rrrrrrrrrrrrrrrrrrrr"+companyObj.getPriceOfShares());
				double reducedPrice = (companyObj.getPriceOfShares()*2)/100;
				//System.out.println("reduced price "+reducedPrice);
				companyObj.setPriceOfShares(companyObj.getPriceOfShares()-reducedPrice);
				//System.out.println("ttttttttttttttttttttttttt"+companyObj.getPriceOfShares());
			}
		}
	}

	public static ArrayList<CompaniesBuilderClass> getListOfCompanies() {
		return companyList;
	}

	private void printCompanies() {

		DecimalFormat decimalFormat = new DecimalFormat("0.00");
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