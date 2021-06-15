package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WestwingnowHomePage {
	
	 WebElement element = null;
	 WebDriver driver = null;
	
	 By productSearch = By.xpath("//input[@type='search']");
	 By productListCount = By.xpath("//div[@class='RegularTitle__StyledProductCount-zjo017-2 efiWHJ']");
	 By wishlistCount = By.xpath("//span[@data-testid='wishlist-counter']");
	 By wishlist = By.xpath("//span[text()='Wunschliste']");
	
	public WestwingnowHomePage(WebDriver driver){
		
		this.driver=driver;		
	}
	
	public WebElement productSearch(){
		
		element = driver.findElement(productSearch);
		return element;
	}
	
	
	public String getProductDisplayedCount(){	
		
		String productCount= driver.findElement(productListCount).getText();	
		return productCount;
	}
	
	public void selectWishlistIconOfNthProduct(int productNumber){		
		
		driver.findElement(By.xpath("//div[@data-testid='plp-products-grid']/div["+productNumber+"]//div[contains(@class,'WishlistIcon__StyledWishlistIconWrapper-sc-75dklq-0 jujCBZ')]")).click();		
	}
	
	
	public String isWishlistIconSelectedForNthProduct(int productNumber ){
		
		String isSelected = driver.findElement(By.xpath("//div[@data-testid='plp-products-grid']/div["+productNumber+"]//div[contains(@class,'WishlistIcon__StyledWishlistIconWrapper-sc-75dklq-0 jujCBZ')]//*[name()='svg']")).getAttribute("data-is-selected");
		return isSelected;
	}
	
	public int getWishlistCount()
	{
		String wishlistCountS=null;
		int wishlistCountValue = 0;
		try
		{
		wishlistCountS= driver.findElement(wishlistCount).getText();		
		}
		catch(Exception e)
		{
			System.out.println(e);
			wishlistCountValue = 0;			
		}
		wishlistCountValue = Integer.parseInt(wishlistCountS);
		return wishlistCountValue;
		
	}
	
	public void clickOnWishlist(){
		
		driver.findElement(wishlist).click();
	
	}
	
	public void deleteNthProductFromWishlist(int productNumber){
		
		driver.findElement(By.xpath("//ul[@class='listProducts']//li["+productNumber+"]//button[@class='blockListProduct__delete qaBlockListProduct__delete']")).click();		
		
	}
	
	public void deleteProductFromWishlistWithProductName(String productName){
		
		driver.findElement(By.xpath("//ul[@class='listProducts']//button[@class='blockListProduct__delete qaBlockListProduct__delete']/..//img[@alt="+productName+"]")).click();			

	}

}
