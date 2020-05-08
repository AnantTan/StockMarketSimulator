package main;

import java.util.HashSet;

import simulation.StockMarketSimulation;
import simulation.TradingDay;

public class Main extends StockMarketSimulation {

	HashSet<String> dd  =new HashSet<>();
	
	private Main()
	{
		startTrading();
//		yes("aa");
	}
	
//	private void yes(String str) {
//	
//	if(dd.add(str))
//	{
//		System.out.println("great");
//	}
//	else
//		System.out.println("no");
//	
//	}
	
	public static void main(String[] args) {

		new Main();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void generateData()
	{
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
}
