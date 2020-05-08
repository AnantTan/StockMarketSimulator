package simulation;

public abstract class StockMarketSimulation {

	abstract protected void generateData();
	abstract protected void startTrade();
	
	protected void startTrading()
	{
		generateData();
		startTrade();
	}
}
