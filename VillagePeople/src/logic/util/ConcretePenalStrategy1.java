package logic.util;

public class ConcretePenalStrategy1 implements PenalStrategy {

	@Override
	public double executeAlgorithm(double prezzo) {
		  return (prezzo/100)*45;
	}

}
