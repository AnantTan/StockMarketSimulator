package builders;

import java.text.DecimalFormat;

public class CompaniesBuilderClass {

	private String uniqueID;
	private String name;
	public int numberOfShares;
	public double priceOfshares;
	public int numberOfSharesSold;
	//public static int totalPriceOfShares;
	//public static int totalNumberOfShares;
	private DecimalFormat format;

	private CompaniesBuilderClass(CompanyBuilder companyBuilder) {
		this.uniqueID = companyBuilder.uniqueID;
		this.name = companyBuilder.name;
		this.numberOfShares = companyBuilder.numberOfShares;
		this.priceOfshares = companyBuilder.priceOfshares;
	//	this.totalPriceOfShares += companyBuilder.priceOfshares;
	//	this.totalNumberOfShares += companyBuilder.numberOfShares;
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

	public double getPriceOfShares() {
		return priceOfshares;
	}

	public void setPriceOfShares(double newPriceOfShares) {
		format = new DecimalFormat("0.00");//set to format to 2 places
		this.priceOfshares = Double.valueOf(format.format(newPriceOfShares));//formatting the price to 2 places
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
