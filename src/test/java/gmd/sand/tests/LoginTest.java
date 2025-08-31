package gmd.sand.tests;

import org.testng.annotations.Test;

import gmd.sand.base.BaseTest;
import gmd.sand.pages.HomePage;

public class LoginTest extends BaseTest {

	@Test
	public void validUserLogin() throws InterruptedException {

		HomePage validLogin = new HomePage(driver);
		validLogin.userLogin("jitendra", "Tester@007");
	}

	@Test
	public void invalidUserLogin() throws InterruptedException {

		HomePage validLogin = new HomePage(driver);
		validLogin.userLogin("jitendra11", "Tester@007");
	}

}
