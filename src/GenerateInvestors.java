import java.util.ArrayList;
import java.util.UUID;

import builders.InvestorBuilderClass;
import companyAndInvestor.CompanyAndInvestor;
import createDynamicData.CreateDynamicData;

public class GenerateInvestors extends CreateDynamicData implements CompanyAndInvestor {

	private String investorName = "";
	private UUID invesotrID;
	private InvestorBuilderClass investor;
	private ArrayList<InvestorBuilderClass> investorList = new ArrayList<>();

	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		//super.run();
//		System.out.println("t 2 s");
//		for(int i=0;i<100;i++)
//		{
//			System.out.print("t2");
//		}
//	
//		System.out.println("t 2 d");
//	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		System.out.println("tast 2 started");
		int count = 0;
		while (count != 100) {
			name(4, 12);
			uniqueID();

			register();
			count++;
		}
		//printInvestors();
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

		investor = new InvestorBuilderClass.InvestorBuilder().uniqueID(invesotrID).name(investorName)
				.budget(getNum(1000, 10000)).build();
		investorList.add(investor);
		//resetValues();
	}

	private void resetValues() {
		investorName = "";
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