package gmd.sand.tests;

import org.testng.annotations.Test;

import gmd.sand.base.BaseTest;
import gmd.sand.utils.ConfigReader;

public class LoginTest extends BaseTest {

	@Test
	public void validUserLogin() throws InterruptedException {
		String username = ConfigReader.getProperty("username");
		String password = ConfigReader.getProperty("password");
		homePage.userLogin(username, password);
	}

	@Test
	public void invalidUserLogin() throws InterruptedException {
		homePage.userLogin("jitendra11", "Tester@007");
	}

}
