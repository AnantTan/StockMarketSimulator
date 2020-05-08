package builders;

public class CompaniesBuilderClass {

	private String uniqueID;
	private String name;
	public int numberOfShares;
	public double priceOfshares;
	public int numberOfSharesSold;

	private CompaniesBuilderClass(CompanyBuilder companyBuilder) {
		this.uniqueID = companyBuilder.uniqueID;
		this.name = companyBuilder.name;
		this.numberOfShares = companyBuilder.numberOfShares;
		this.priceOfshares = companyBuilder.priceOfshares;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public double getPriceOfshares() {
		return priceOfshares;
	}

	public void setPriceOfShares(double newPriceOfShares) {
		this.priceOfshares = newPriceOfShares;
	}

	public static class CompanyBuilder {
		private String uniqueID;
		private String name;
		private int numberOfShares;
		private double priceOfshares;

		public CompanyBuilder uniqueID(String uniqueID) {
			this.uniqueID = uniqueID;
			return this;
		}

		public CompanyBuilder name(String name) {
			this.name = name;
			return this;
		}

		public CompanyBuilder numbersOfShares(int numberOfShares) {
			this.numberOfShares = numberOfShares;
			return this;
		}

		public CompanyBuilder priceOfShares(double priceOfShares) {
			this.priceOfshares = priceOfShares;
			return this;
		}

		public CompaniesBuilderClass build() {
			return new CompaniesBuilderClass(this);
		}
	}
}
