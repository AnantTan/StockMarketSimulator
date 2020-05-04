import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class CreateDynamicData {

	private String[] letterPool = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "k", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	private String[] organisationPool = { ".inc", ".group", ".tech", ".sons", ".co" };
	private Random random = new Random();
	int totalAlphabets;// this will create a word using total the random limit given
	private String companyName = "";
	private String uniqueID;
	private String orgType;
	private HashSet<String> registerationSet = new HashSet<>();
	private ArrayList<CompaniesBuilderClass> companyList = new ArrayList<>();
	private CompaniesBuilderClass company;

	public CreateDynamicData() {

		int count = 0;
		while (count != 100) {
			createCompanyName();
			count++;
		}
		print();
	}

	private void print() {

		int i=1;
		for (CompaniesBuilderClass builderClass : companyList) {
			
			System.out.println("ID:\t"+builderClass.getUniqueID());
			System.out.println("Name:\t" + builderClass.getName());
			System.out.println("Number of share:\t"+builderClass.getNumberOfShares());
			System.out.println("Price of shares:\t"+builderClass.getPriceOfshares());
			System.out.println(i);
			System.out.println();
			i++;
		}
	}

	private void createCompanyName() {

		totalAlphabets = random.nextInt(10 - 3);// name length of the company
		int i = 0;
		while (i != totalAlphabets) {
			int letter = random.nextInt(26);// get a random number to pick a letter
			companyName += letterPool[letter];// select the letter at that position
			i++;
		}
		orgType = organisationPool[random.nextInt(4)];
		companyName = companyName.concat(orgType);// get type of organization from the pool
		checkNameAvailabilityBeofreRegistering(companyName);
	}

	private void checkNameAvailabilityBeofreRegistering(String companyName) {
		if (registerationSet.add(companyName)) {
			createUniqueID();
		} else
			createCompanyName();// if name not added find another name
	}

	private void createUniqueID() {

		uniqueID = random.nextInt(150) + orgType;
		checkIDAvailablilityBeforeRegistering(uniqueID);
	}

	private void checkIDAvailablilityBeforeRegistering(String uniqueID) {

		if (registerationSet.add(uniqueID)) {
			establishTheComapany();
		} else
			createUniqueID();// if ID not added find another Id
	}

	private void establishTheComapany() {

		company = new CompaniesBuilderClass.CompanyBuilder().uniqueID(uniqueID).name(companyName)
				.numbersOfShares(random.nextInt(1000 - 500)).priceOfShares(random.nextInt(100 - 10)).build();
		companyList.add(company);
		resetValues();
	}
	
	private void resetValues()
	{
		uniqueID = "";
		companyName = "";
	}

	public static void main(String[] args) {
		new CreateDynamicData();
	}

}
