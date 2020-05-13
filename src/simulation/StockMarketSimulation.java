package simulation;

/*
 * template pattern
 * this describes the sequence in which a program runs
 */
public abstract class StockMarketSimulation {

	abstract protected void generateData();
	abstract protected void startTrade();
	abstract protected void tradingReport();
	abstract protected void userInteraction();
	
	protected void startTrading()
	{
		generateData();//generating data is the first step
		startTrade();//this will simulate the trade
		tradingReport();//after the trade is done a report will be created
		userInteraction();//this will retrieve the report
	}
}
