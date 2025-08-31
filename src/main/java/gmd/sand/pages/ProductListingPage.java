
package gmd.sand.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gmd.sand.base.BaseTest;
import gmd.sand.utils.CommonActions;

public class ProductListingPage extends BaseTest {
    WebDriver driver;
    
    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[@id=\"Products_0\"]")
    WebElement productsLink;
    
    @FindBy(xpath="//a[@href=\"/Catalog/Nursing-Home-Furniture\"]")
    WebElement furnitureCategoryPLPLink;
    
    @FindBy(css="a[data-test-selector^=\"categoryDetailsSubCategoriesLink\"]")
    WebElement furnitureChairSubCategoryLink;
    
    @FindBy(xpath="//button[contains(@data-test-selector,'actionsAddToCart')]")
    WebElement addToCartButton;
    

    public void navigateToProductsCategoryLandingPage() {
		CommonActions.click(productsLink);
		CommonActions.click(furnitureCategoryPLPLink);
	}
	
	public void navigateToCategoryProductListingPage()
	{
		CommonActions.click(furnitureChairSubCategoryLink);	
	}
	
	public void addProductsToCartFromPLP()
	{
		CommonActions.click(addToCartButton);
	}	
	
 }

