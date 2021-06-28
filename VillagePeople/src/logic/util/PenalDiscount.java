package logic.util;

public class PenalDiscount {
	private PenalStrategy strategy = new ConcretePenalStrategy1();
	
	
	
	public double execute(double prezzo) {
		 return strategy.executeAlgorithm(prezzo);
	}
	
	public void setStrategy(PenalStrategy newStrategy) {
		strategy = newStrategy;
	}
	
	public PenalStrategy getStrategy() {
		return strategy;
	}
	
	

}
