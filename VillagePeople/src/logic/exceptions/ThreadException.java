package logic.exceptions;

import java.util.concurrent.ExecutorService;

public class ThreadException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ThreadException() {
		super();
	}
	
	public void solve(ExecutorService service) {
		service.shutdownNow();
	}

}
