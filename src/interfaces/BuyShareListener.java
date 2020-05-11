package interfaces;

import builders.CompaniesBuilderClass;
import builders.InvestorBuilderClass;

@FunctionalInterface
public interface BuyShareListener {

	void update(InvestorBuilderClass investor,CompaniesBuilderClass company);
}
