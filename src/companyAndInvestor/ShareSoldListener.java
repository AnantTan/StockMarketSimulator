package companyAndInvestor;

import builders.CompaniesBuilderClass;

@FunctionalInterface
public interface ShareSoldListener {

	public void update(CompaniesBuilderClass company);
}
