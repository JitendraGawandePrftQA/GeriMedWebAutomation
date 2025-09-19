
package gmd.sand.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import gmd.sand.base.BaseTest;
import gmd.sand.utils.CommonActions;

public class ProductListingPage extends BaseTest {
	WebDriver driver;
	ExtentTest test;

	public ProductListingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='Products_0']")
	WebElement productsLink;

	@FindBy(xpath = "//a[@href='/Catalog/Nursing-Home-Furniture']")
	WebElement furnitureCategoryPLPLink;

	@FindBy(css = "a[data-test-selector^='categoryDetailsSubCategoriesLink']")
	WebElement furnitureChairSubCategoryLink;

	@FindBy(xpath = "//button[contains(@data-test-selector,'actionsAddToCart')]")
	WebElement addToCartButton;

	public void navigateToProductsCategoryLandingPage() {
		CommonActions.click(productsLink);
		CommonActions.click(furnitureCategoryPLPLink);
		test.info("Clicked on a category PLP link");
	}

	public void navigateToCategoryProductListingPage() {
		CommonActions.click(furnitureChairSubCategoryLink);
		test.info("Clicked on a sub-category PLP link");
	}

	public void addProductsToCartFromPLP() {
		CommonActions.click(addToCartButton);
		test.info("Clicked on Add To Cart button to add product to cart from PLP");
	}

}
