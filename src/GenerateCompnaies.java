import java.util.ArrayList;

import builders.CompaniesBuilderClass;
import companyAndInvestor.CompanyAndInvestor;
import createDynamicData.CreateDynamicData;

public class GenerateCompnaies extends CreateDynamicData implements CompanyAndInvestor {

	private String companyName = "", uniqueID="",orgType="";
	private CompaniesBuilderClass company;
	private ArrayList<CompaniesBuilderClass> companyList = new ArrayList<>();

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//	//	super.run();
//		System.out.println("t 1 s");
//		for(int i=0;i<100;i++)
//		{
//			System.out.print("t1");
//		}
//		System.out.println("t 1 d");
//	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		System.out.println("tast 1 started");

		int count=0;
		while(count!=100)
		{
		name(3, 10);
		if (checkAvailablilityBeforeRegistering(companyName)==true) {
			orgType = getOrganisationType();// get type of organization from the pool		
			companyName = companyName.concat(orgType);// get type of organization from the pool
			uniqueID();
			if (checkAvailablilityBeforeRegistering(uniqueID)==true) {
				register();
				count++;
			} else
				uniqueID();
		} else
		{
			name(3, 10);
		}
		}
		printCompanies();
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
		resetValues();
	}
	
	private void resetValues() {
		companyName = "";
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
