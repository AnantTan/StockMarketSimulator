package createDynamicData;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

public abstract class CreateDynamicData extends Thread {

	private String[] letterPool = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "k", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	private String[] organisationPool = { ".inc", ".group", ".tech", ".sons", ".co" };
	private Random random = new Random();
	int totalAlphabets;// this will create a word using total the random limit given
	private String companyUniqueID;
	private String orgType;
	private HashSet<String> registerationSet = new HashSet<>();
	private String name="";
			
	protected String generateName(int start, int end) {
		
		resetValues();//reset name when creating new one
		totalAlphabets = getNum(start, end);
		int i = 0;
		while (i != totalAlphabets) {
			int letter = random.nextInt(26);// get a random number to pick a letter
			name += letterPool[letter];// select the letter at that position
			i++;
		}
		return name;
	}

//	protected boolean checkNameAvailabilityBeofreRegistering(String name) {
//		if (registerationSet.add(name)) {
//			return true;
//			//createUniqueID();
//		} else
//			return false;
//			//createCompanyName();// if name not added find another name
//	}

	protected String createComapnyUniqueID() {

		companyUniqueID = String.valueOf(random.nextInt(150));
		//checkAvailablilityBeforeRegistering(companyUniqueID);
		return companyUniqueID;
	}

	protected boolean checkAvailablilityBeforeRegistering(String check) {

		if (registerationSet.add(check)) {
			return true;
		} else
			return false;
	}

	protected int getNum(int start, int end) {
		return (new Random().nextInt(end + 1 - start) + start);
	}
	
	protected UUID getInvesotrID()
	{
		 return UUID.randomUUID();
	}
	
	protected String getOrganisationType()
	{
		return organisationPool[random.nextInt(4)];
	}
	
	private void resetValues()
	{
		name="";
	}
}