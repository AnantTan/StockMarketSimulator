package builders;

public class CompaniesBuilderClass {

	private String uniqueID;
	private String name;
	private int numberOfShares;
	private int priceOfshares;

	private CompaniesBuilderClass(CompanyBuilder companyBuilder)
	{
		this.uniqueID = companyBuilder.uniqueID;
		this.name = companyBuilder.name;
		this.numberOfShares = companyBuilder.numberOfShares;
		this.priceOfshares = companyBuilder.priceOfshares;
	}
	
	public String getUniqueID() {
		return uniqueID;
	}

	public String getName()
	{
		return name;
	}
	
	public int getNumberOfShares() {
		return numberOfShares;
	}

	public int getPriceOfshares() {
		return priceOfshares;
	}
	
	public static class CompanyBuilder
	{
		private String uniqueID;
		private String name;
		private int numberOfShares;
		private int priceOfshares;
		
		public CompanyBuilder uniqueID(String uniqueID)
		{
			this.uniqueID = uniqueID;
			return this;
		}
		
		public CompanyBuilder name(String name)
		{
			this.name = name;
			return this;
		}
		
		public CompanyBuilder numbersOfShares(int numberOfShares)
		{
			this.numberOfShares = numberOfShares;
			return this;
		}
		
		public CompanyBuilder priceOfShares(int priceOfShares)
		{
			this.priceOfshares = priceOfShares;
			return this;
		}
		
		public CompaniesBuilderClass build()
		{
			return new CompaniesBuilderClass(this);
		}
	}
}
