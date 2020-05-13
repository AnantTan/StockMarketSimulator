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
	private int numberOfSharesSold = 0;
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
		}
	}

	public void trade(CompaniesBuilderClass company, InvestorBuilderClass investor) {

		Trade trade = new Trade(company, investor);
		if (investor.getBudget() < company.getPriceOfShares() || company.getNumberOfShares() == 0) {

			trade.checkIfInvestorCanBuyAnywhere();
			return;

		} else {
			// sell shares
			// observer
			sharesSold.add(company);// add a company when any 10 shares are sold
			// if 10 shares are sold
			if (numberOfSharesSold == 10) {
				updatePrices();
			}
			buyAndSellShares();
		}
		// proxy to remove an investor or a company
		trade.checkInvestor();
		trade.checkCompany();
	}

	private void updatePrices() {
		numberOfSharesSold = 0;// reset the counter to count new shares sold
		companies.reducePriceOfShares(sharesSold);
		sharesSold.clear();// remove all the companies from the set
	}

	private void buyAndSellShares() {
		numberOfSharesSold++;
		investors.update(investor, company);
		companies.update(company);
	}
}