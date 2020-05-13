package simulation;

public abstract class StockMarketSimulation {

	abstract protected void generateData();
	abstract protected void startTrade();
	abstract protected void tradingReport();
	
	protected void startTrading()
	{
		generateData();
		startTrade();
		tradingReport();
	}
}
