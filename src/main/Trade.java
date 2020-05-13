package main;

import builders.CompaniesBuilderClass;
import builders.InvestorBuilderClass;
import interfaces.TradingProxies;
import simulation.TradingDay;

public class Trade implements TradingProxies {

	private CompaniesBuilderClass company;
	private InvestorBuilderClass investor;

	public Trade(CompaniesBuilderClass company, InvestorBuilderClass investor) {

		this.company = company;
		this.investor = investor;
	}

	@Override
	public void checkInvestor() {

		//if investor's budget is less than or = 0 remove it this will make it a bit efficient
		if (investor.getBudget() <= 0) {
			TradingDay.investorList.remove(investor);
		}
	}

	@Override
	public void checkCompany() {
		
		//if the companies share number = 0 remove it 
		if (company.getNumberOfShares() <= 0) {
			TradingDay.companyList.remove(company);
		}
	}

	@Override
	public void checkIfInvestorCanBuyAnywhere() {

		//if the investor cannot buy share from any company remove it
		for (CompaniesBuilderClass company : TradingDay.companyList) {
			if (investor.getBudget() > company.getPriceOfShares() && company.getNumberOfShares() > 0) {
				return;
			}
		}
		TradingDay.investorList.remove(investor);
	}
}