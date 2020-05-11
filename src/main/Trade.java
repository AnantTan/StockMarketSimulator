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

		if (investor.getBudget() <= 0) {
			TradingDay.investorList.remove(investor);
		}
	}

	@Override
	public void checkCompany() {
		if (company.getNumberOfShares() <= 0) {
			TradingDay.companyList.remove(company);
		}
	}

	@Override
	public void checkIfInvestorCanBuyAnywhere() {

		for (CompaniesBuilderClass company : TradingDay.companyList) {
			if (investor.getBudget() > company.getPriceOfShares() && company.getNumberOfShares() > 0) {
				return;
			}
		}
		TradingDay.investorList.remove(investor);
	}
}