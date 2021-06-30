package logic.util;

import java.security.SecureRandom;
import java.util.concurrent.Callable;

public class RetInt implements Callable<Integer> {
	private SecureRandom random = new SecureRandom();
    public  RetInt() {//COSTRUTTORE
    }
 
    @Override
    public Integer call() {
		int i;
		int a = 10000; // numero minimo
		int b = 1000000; // numero massimo
		int c = ((b-a) + 1);
		i = random.nextInt(c) + a;
        return i;
    }
}