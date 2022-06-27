package utilities;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethod {

	WebDriver driver;
	WebElement element;

	public GenericMethod (WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String locator, String type) {
		type = type.toLowerCase();

		if(type.equals("id")) {
			System.out.println("Element found with id: " + locator);
			return this.driver.findElement(By.id(locator));
		}else if(type.equals("xpath")) {
			System.out.println("Element found with xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));
		}else if(type.equals("class")) {
			System.out.println("Element found with xpath" + locator);
			return this.driver.findElement(By.xpath(locator));
		}else if(type.equals("name")) {
			System.out.println("Element found with name" + locator);
			return this.driver.findElement(By.name(locator));
		}
		else
			System.out.println("locator type not supported");
		return null;
	}

	public List<WebElement> getElementList(String locator, String type){
		type = type.toLowerCase();

		List<WebElement> elementList = new ArrayList<WebElement>();


		if(type.equals("id")) {
			elementList = this.driver.findElements(By.id(locator));
		}else if(type.equals("xpath")) {
			elementList = driver.findElements(By.xpath(locator));
		}else if(type.equals("className")) {
			elementList = driver.findElements(By.className(locator));
		}else if(type.equals("name")) {
			elementList = this.driver.findElements(By.name(locator));
		}else if(type.equals("tagName")) {
			elementList = this.driver.findElements(By.tagName(locator));
		}else if(type.equals("linkText")) {
			elementList = this.driver.findElements(By.linkText(locator));
		}else if(type.equals("partialLinkText")) {
			elementList = this.driver.findElements(By.partialLinkText(locator));
		}else
			System.out.println("locator type not supported");

		if(elementList.isEmpty()) {
			System.out.println("element not found with " + type + ": " + locator);
		}else
			System.out.println("element found with " + type + ": " + locator);
		return elementList;
	}

	public boolean isElementPresent(String locator, String type) {
		List<WebElement> elementList = getElementList(locator, type);

		int size = elementList.size();

		if(size>0) {
			return true;
		}else
			return false;
	}


	public WebElement waitForElement(By locator, Duration timeout) { // in selenium 3 public WebElement waitForElement(By locator, int timeout)
		try {
			System.out.println("Waiting for max:: "+ timeout + " seconds for the element to be available");

			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element appeared on the web page");

		}catch (Exception e) {
			System.out.println("Element not appeared on the web page");
		}
		return element;
	}

	public  void clickWhenReady(By locator, Duration timeout) {
		WebElement element = null;
		try {
			System.out.println("Waiting for max:: "+ timeout + " seconds for the element to be clickable");

			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element clicked on the web page");

		}catch (Exception e) {
			System.out.println("Element not appeared on the web page");
		}
	}

}
