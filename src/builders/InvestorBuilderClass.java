package builders;
import java.util.UUID;

public class InvestorBuilderClass {

	private UUID uniqueID;
	private String name;
	public double budget;
	public int numberOfsharesBought;
	
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

	public double getBudget() {
		return budget;
	}
	
	public static class InvestorBuilder{
		
		private UUID uniqueID;
		private String name;
		private double budget;
		
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
		
		public InvestorBuilder budget(double budget)
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
