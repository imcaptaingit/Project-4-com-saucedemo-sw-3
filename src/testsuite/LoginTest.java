package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseURL = "https://www.saucedemo.com/";

    @Before
    public void setBaseUrl() {

        openBrowser(baseURL);

    }


    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        sendTextToElement(By.name("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.name("login-button"));
        String ExpectedPro = "Products";
        String ActualPro = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals("Messsage on the top is not displayed", ActualPro, ExpectedPro);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(By.name("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.name("login-button"));

        //Verify that six products are displayed on page
        List<WebElement> productList = driver.findElements(By.className("inventory_item"));
        driver.findElements(By.className("inventory_item"));
        System.out.println("Total Product: " + productList.size());
        // Verify the number of products is 6
        int expectSize = 6;
        int actualSize = productList.size();
        Assert.assertEquals(expectSize, actualSize);

    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}