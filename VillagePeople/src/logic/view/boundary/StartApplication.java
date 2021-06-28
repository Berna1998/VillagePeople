package logic.view.boundary;

import logic.view.controllergrafico.ControllerGrafico;
import logic.view.controllergrafico.ControllerGraficoAdmin;

public class StartApplication {
	
	public static final ControllerGrafico c1 = new ControllerGrafico();
	public static final ControllerGraficoAdmin c2 = new ControllerGraficoAdmin();

	public static void main(String[] args) {
		
		c1.startwithLoginGUI();
	}

}
