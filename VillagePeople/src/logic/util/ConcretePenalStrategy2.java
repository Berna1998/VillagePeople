package logic.util;

public class ConcretePenalStrategy2 implements PenalStrategy {

	@Override
	public double executeAlgorithm(double prezzo) {
		 return (prezzo/100)*30;	
	}

}
