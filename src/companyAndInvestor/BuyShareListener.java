package companyAndInvestor;

import builders.InvestorBuilderClass;

@FunctionalInterface
public interface BuyShareListener {

	void update(InvestorBuilderClass investor);
}
