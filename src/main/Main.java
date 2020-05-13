package main;

import java.util.HashSet;

import simulation.StockMarketSimulation;
import simulation.TradingDay;

public class Main extends StockMarketSimulation {

	HashSet<String> dd = new HashSet<>();
	private TradingReport tradingReport;

	private Main() {
		startTrading();
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void generateData() {

		Thread companies = new Thread(new Companies());
		companies.start();// create companies dynamically
		Thread investors = new Thread(new Investors());
		investors.start();// create investors dynamically
		try {
			// synchronizing threads in order to move further when they are completed
			companies.join();
			investors.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// stop the threads
		companies.stop();
		investors.stop();
	}

	@Override
	protected void startTrade() {
		new TradingDay();
	}

	@Override
	protected void tradingReport() {

		tradingReport = new TradingReport();
	}

	@Override
	protected void userInteraction() {

		new UserIntreaction(tradingReport);
	}

	public static void main(String[] args) {

		new Main();
	}
}