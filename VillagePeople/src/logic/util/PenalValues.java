package logic.util;

import java.util.concurrent.Callable;

public class PenalValues implements Callable<Double>  { 
	private double prezzo;
	private int tipo;
    
	public PenalValues(double prezzo, int tipo) {
    	this.prezzo = prezzo;
    	this.tipo = tipo;
    }
 
    @Override
    public Double call() {
    	PenalDiscount penal = new PenalDiscount();
    	if (tipo == 2) {
    		PenalStrategy newStrategy = new ConcretePenalStrategy2();
    		penal.setStrategy(newStrategy);
    	}
    	return penal.execute(prezzo);    
    }
    
    
}
