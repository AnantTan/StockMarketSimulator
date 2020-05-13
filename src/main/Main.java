package main;

import java.util.HashSet;

import simulation.StockMarketSimulation;
import simulation.TradingDay;

public class Main extends StockMarketSimulation {

	HashSet<String> dd = new HashSet<>();

	private Main() {
		startTrading();
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void generateData() {
		Thread companies = new Thread(new Companies());
		companies.start();
		Thread investors = new Thread(new Investors());
		investors.start();
		try {
			companies.join();
			investors.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		companies.stop();
		investors.stop();
	}

	@Override
	protected void startTrade() {
		new TradingDay();
	}

	@Override
	protected void tradingReport() {
		
		TradingReport tradingReport = new TradingReport();
		tradingReport.calculateCapital();
		tradingReport.investorWithHighestNumberOfShares();
	}

	public static void main(String[] args) {

		new Main();
	}

}
