package es.klodike.controllers.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MoveFromDeckToWasteControllerTest.class,
		MoveFromWasteToFoundationControllerTest.class,
		MoveFromWasteToTableauControllerTest.class, StartControllerTest.class })
public class AllTests {

}
