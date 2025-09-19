package gmd.sand.tests;

import org.testng.annotations.Test;

import gmd.sand.base.BaseTest;

public class LoginTestWithExcelData extends BaseTest {

	@Test(dataProvider = "loginData", dataProviderClass = gmd.sand.utils.ExcelReader.class)
	public void validUserLogin(String username, String password) throws InterruptedException {
		homePage.userLogin(username, password);
	}
}
