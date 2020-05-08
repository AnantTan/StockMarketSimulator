package main;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Callable;

import builders.CompaniesBuilderClass;
import builders.InvestorBuilderClass;
import companyAndInvestor.BuyShareListener;
import companyAndInvestor.CompanyAndInvestor;
import simulation.CreateDynamicData;

public class Investors extends CreateDynamicData implements CompanyAndInvestor, BuyShareListener {

	private String investorName = "";
	private UUID invesotrID;
	private InvestorBuilderClass investor;
	public static ArrayList<InvestorBuilderClass> investorList = new ArrayList<>();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("tast 2 started");
		int count = 0;
		while (count != 20) {
			//name(4, 12);
			uniqueID();
			register();
			count++;
		}
		printInvestors();
		System.out.println("///////////////////////////////////////task 2 done");
	}

	@Override
	public void uniqueID() {

		this.invesotrID = getInvesotrID();
	}

	@Override
	public void name(int start, int end) {

		this.investorName = generateName(start, end);
	}

	@Override
	public void register() {

//		investor = new InvestorBuilderClass.InvestorBuilder().uniqueID(invesotrID).name("An")
//				.budget(400).build();
//		
//		investorList.add(investor);
//		
//		investor = new InvestorBuilderClass.InvestorBuilder().uniqueID(invesotrID).name("Ab")
//				.budget(500).build();
//		
//		investorList.add(investor);
//		
//		investor = new InvestorBuilderClass.InvestorBuilder().uniqueID(invesotrID).name("Sw")
//				.budget(600).build();
//		
//		investorList.add(investor);

		investor = new InvestorBuilderClass.InvestorBuilder().uniqueID(invesotrID).name(investorName)
				.budget(getNum(1000, 10000)).build();

		investorList.add(investor);

		//resetValues();
	}
	
	@Override
	public void update(InvestorBuilderClass investor) {

		investor.numberOfsharesBought++;
	}

	
	public static ArrayList<InvestorBuilderClass> getListOfInvestors()
	{
		return investorList;
	}
	
	private void printInvestors() {
		
		int i = 1;
		for (InvestorBuilderClass builderClass : investorList) {

			System.out.println("ID:\t" + builderClass.getUniqueID());
			System.out.println("Name:\t" + builderClass.getName());
			System.out.println("Number of share:\t" + builderClass.getBudget());
			System.out.println("Number of investors= " + i);
			System.out.println();
			i++;
		}
	}
}