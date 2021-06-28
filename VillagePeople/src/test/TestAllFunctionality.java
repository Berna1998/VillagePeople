package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestEliminazioneAttivita.class, TestEliminazionePrenotazione.class, 
	TestInserisciAttivitaAdmin.class, TestLogin.class, TestMenuAdmin.class, TestMenuClient.class,
	TestModificaAttivitaAdmin.class, TestPrenotazioneAttivita.class, TestSignUp.class})


public class TestAllFunctionality {
}
