import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new GenerateCompnaies());
		executorService.execute(new GenerateInvestors());
		executorService.shutdown();
	}
}
