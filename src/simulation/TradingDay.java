package simulation;

import java.util.ArrayList;
import java.util.HashSet;

import builders.CompaniesBuilderClass;
import builders.InvestorBuilderClass;
import main.Companies;
import main.Investors;

public class TradingDay extends CreateDynamicData {

	private CompaniesBuilderClass company;
	private InvestorBuilderClass investor;
	private Investors investors;
	private Companies companies;
	private ArrayList<CompaniesBuilderClass> companyList = new ArrayList<>();
	private ArrayList<InvestorBuilderClass> investorList = new ArrayList<>();
	private HashSet<CompaniesBuilderClass> sharesSold = new HashSet<>();

	public TradingDay() {

		companyList = Companies.getListOfCompanies();
		investorList = Investors.getListOfInvestors();

		companies = new Companies();
		investors = new Investors();

		while (companyList.size() > 0 && investorList.size() > 0) {
			company = companyList.get(getNum(0, companyList.size() - 1));
			// System.out.println("sizeee "+investorList.size());
			investor = investorList.get(getNum(0, investorList.size() - 1));

			trade(company, investor);

			System.out.println();
			System.out.println("name= " + investor.getName() + " Budget= " + investor.getBudget());
			System.out.println("name= " + company.getName() + " Shares= " + company.getNumberOfShares());
			System.out.println("_________________________________________________________");
		}
	}

	public void trade(CompaniesBuilderClass company, InvestorBuilderClass investor) {

		if (investor.getBudget() < company.getPriceOfshares() || company.getNumberOfShares() == 0) {
			return;
		} else {
			// sell shares
			// observer
			sharesSold.add(company);
			if (sharesSold.size() == 10) {
				System.out.println("nnfne");
				companies.reducePriceOfShares(sharesSold);
				sharesSold.clear();//remove all the companies from the set
			}
			investors.update(investor);
			companies.update(company);
		}

		investor.budget -= company.getPriceOfshares();

		if (investor.getBudget() <= 0) {
			// i++;
			investorList.remove(investor);
		}

		// company.numberOfShares=0;
		if (company.numberOfShares <= 0) {
			// j++;
			companyList.remove(company);
		}

		// trade2(company,investor);
	}

//	public void trade(CompaniesBuilderClass company, InvestorBuilderClass investor) {
//
////		investor.budget -= 50;
////		investor.numberOfshares++;
////		System.out.println(investor.getName());
////		System.out.println(investor.getBudget());
////		System.out.println(investor.getNumberOfShares());
//		
//		company.numberOfShares--;
//		company.numberOfSharesSold++;
//		System.out.println(company.getName());
//		System.out.println(company.getNumberOfShares());
//		System.out.println(company.numberOfSharesSold);
//	
//		company = Companies.getListOfCompanies().get(2);
//		investor = Investors.getListOfInvestors().get(2);
//
//		trade2(company,investor);
//	}

	public void trade2(CompaniesBuilderClass company, InvestorBuilderClass investor) {

//		investor.budget--; 
//		System.out.println(investor.getName());
//		System.out.println(investor.getBudget());
//		System.out.println(investor.getNumberOfShares());

		System.out.println(company.getName());
		System.out.println(company.getNumberOfShares());
		System.out.println(company.numberOfSharesSold);

		company = Companies.getListOfCompanies().get(1);
		investor = Investors.getListOfInvestors().get(1);

		trade3(company, investor);

	}

	public void trade3(CompaniesBuilderClass company, InvestorBuilderClass investor) {

		// investor.budget--;
//		System.out.println(investor.getName());
//		System.out.println(investor.getBudget());
//		System.out.println(investor.getNumberOfShares());

		System.out.println(company.getName());
		System.out.println(company.getNumberOfShares());
		System.out.println(company.numberOfSharesSold);

	}
}