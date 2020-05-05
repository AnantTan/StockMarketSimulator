package builders;
import java.util.UUID;

public class InvestorBuilderClass {

	private UUID uniqueID;
	private String name;
	private int budget;
	
	private InvestorBuilderClass(InvestorBuilder builder)
	{
		this.uniqueID = builder.uniqueID;
		this.name = builder.name;
		this.budget = builder.budget;
	}

	public UUID getUniqueID() {
		return uniqueID;
	}

	public String getName() {
		return name;
	}

	public int getBudget() {
		return budget;
	}
	
	public static class InvestorBuilder{
		
		private UUID uniqueID;
		private String name;
		private int budget;
		
		public InvestorBuilder uniqueID(UUID uniqueID)
		{
			this.uniqueID = uniqueID;
			return this;
		}
		
		public InvestorBuilder name(String name)
		{
			this.name = name;
			return this;
		}
		
		public InvestorBuilder budget(int budget)
		{
			this.budget = budget;
			return this;
		}
		
		public InvestorBuilderClass build()
		{
			return new InvestorBuilderClass(this);
		}
	}
}
