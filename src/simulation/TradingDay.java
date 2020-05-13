package simulation;

import java.util.ArrayList;
import java.util.HashSet;

import builders.CompaniesBuilderClass;
import builders.InvestorBuilderClass;
import main.Companies;
import main.Investors;
import main.Trade;

public class TradingDay extends CreateDynamicData {

	private CompaniesBuilderClass company;
	private InvestorBuilderClass investor;
	private Investors investors;
	private Companies companies;
	private int numberOfSharesSold=0;
	public static ArrayList<CompaniesBuilderClass> companyList = new ArrayList<>();
	public static ArrayList<InvestorBuilderClass> investorList = new ArrayList<>();
	private HashSet<CompaniesBuilderClass> sharesSold = new HashSet<>();
	
	public TradingDay() {

		companies = new Companies();
		investors = new Investors();
		companyList = companies.getCompanyList();
		investorList = investors.getInvestorList();

		companies = new Companies();
		investors = new Investors();

		while (companyList.size() > 0 && investorList.size() > 0) {
			company = companyList.get(getNum(0, companyList.size() - 1));
			investor = investorList.get(getNum(0, investorList.size() - 1));

			trade(company, investor);

//			System.out.println();
//			System.out.println("name= " + investor.getName() + " Budget= " + investor.getBudget());
//			System.out.println("name= " + company.getName() + " Price= " + company.getPriceOfShares());
//			System.out.println("name= " + company.getName() + " Shares= " + company.getNumberOfShares());
//
//			System.out.println("_________________________________________________________");
		}
		output();
	}

	private void output() {
		
	System.out.println();
	for (InvestorBuilderClass investor : investorList) {
		
		System.out.println("money left "+investor.getBudget());
	}
	System.out.println(investorList.size());
	System.out.println();
	for (CompaniesBuilderClass company : companyList) {
		System.out.println("NAme " +company.getName());
//		if(company.getPriceOfShares()>100)
//		{
//			System.out.println("Price "+company.getPriceOfShares());
//			System.exit(0);
//		}
		System.out.println("Price "+company.getPriceOfShares());
		System.out.println("share number "+company.getNumberOfShares());
		System.out.println("_______________________________________________");
	}
	System.out.println(companyList.size());
}

	public void trade(CompaniesBuilderClass company, InvestorBuilderClass investor) {

		Trade trade = new Trade(company, investor);
		if (investor.getBudget() < company.getPriceOfShares() || company.getNumberOfShares() == 0) {

			trade.checkIfInvestorCanBuyAnywhere();
			return;

		} else {
			// sell shares
			// observer
			sharesSold.add(company);//add a company when any 10 shares are sold
			//if 10 shares are sold
			if (numberOfSharesSold == 10) {
				updatePrices();
			}
			buyAndSellShares();
		}
		//proxy to remove an investor or a company
		trade.checkInvestor();
		trade.checkCompany();
	}
	
	private void updatePrices()
	{
		numberOfSharesSold=0;//reset the counter to count new shares sold
		//System.out.println("nnfne");
		companies.reducePriceOfShares(sharesSold);
		//System.exit(0);
		sharesSold.clear();// remove all the companies from the set
	}
	
	private void buyAndSellShares()
	{
		numberOfSharesSold++;
		investors.update(investor, company);
		companies.update(company);
	}
}