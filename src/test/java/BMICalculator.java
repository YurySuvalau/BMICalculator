import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class BMICalculator {
    String address = "https://healthunify.com/bmicalculator/";
    WebDriver driver = new ChromeDriver();


    @BeforeMethod
    public void initMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @Test
    //This test should verify Normal category on home page
    public void calculateNormal() {
        //1.Open https://healthunify.com/bmicalculator/
        driver.get(address);
        //2.Enter weight 80
        driver.findElement(By.name("wg")).sendKeys("80");
        //3. Enter height 180
        driver.findElement(By.name("ht")).sendKeys("180");
        //4.Click calculate button
        driver.findElement(By.name("cc")).click();
        //5. Chek displayed message "Your category is Normal"
        String textActualResult = driver.findElement(By.name("desc")).getAttribute("value");
        String textExpectedResult = "Your category is Normal";
        Assert.assertEquals(textActualResult, textExpectedResult, "Incorrect category is displayed!" + textActualResult);
        driver.close();

    }

    @Test
    //This test should verify Obese category on home page.
    public void calculateKgCmsObese() {

        //1. Open site https://healthunify.com/bmicalculator/
        driver.get(address);
        //2. Enter 80 in Weight field
        driver.findElement(By.name("wg")).sendKeys("140");
        //3. Enter 180 in Height field
        driver.findElement(By.name("ht")).sendKeys("180");
        //4. Click Calculate button
        driver.findElement(By.name("cc")).click();
        String actualCategoryText = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedCategoryText = "Your category is Obese";
        //5. Check text 'Your category is Obese' is displayed
        Assert.assertEquals(actualCategoryText, expectedCategoryText, "Incorrect category is displayed! UI shows:  " + actualCategoryText);
        driver.close();
    }

    @Test
    //This test should verify Starvation category on home page.
    public void calculateKgCmsStarvation() {

        //1. Open site https://healthunify.com/bmicalculator/
        driver.get(address);
        //2. Enter 80 in Weight field
        driver.findElement(By.name("wg")).sendKeys("30");
        //3. Enter 180 in Height field
        driver.findElement(By.name("ht")).sendKeys("190");
        //4. Click Calculate button
        driver.findElement(By.name("cc")).click();
        String actualCategoryText = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedCategoryText = "Your category is Starvation";
        //5. Check text 'Your category is Starvation' is displayed
        Assert.assertEquals(actualCategoryText, expectedCategoryText, "Incorrect category is displayed! UI shows:  " + actualCategoryText);
        driver.close();

    }

    @Test
    //This test should verify Underweight category on home page.
    public void calculateKgCmsUnderweight() {


        //1.Open site https://healthunify.com/bmicalculator/
        driver.get(address);
        //2. Enter 43 in Weight field
        driver.findElement(By.name("wg")).sendKeys("43");
        //3. Enter 165 in Height field
        driver.findElement(By.name("ht")).sendKeys("160");
        //4. Click Calculate button
        driver.findElement(By.name("cc")).click();
        String actualCategoryText = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedCategoryText = "Your category is Underweight";
        //5. Chek text "Your category is Underweight" is displayed
        Assert.assertEquals(actualCategoryText, expectedCategoryText, "Incorrect category is displayed! UI shows:  " + actualCategoryText);
        driver.close();
    }

    @Test
    //This test should verify Overweight category on home page.
    public void calculateKgCmsOverweight() {


        //1.Open site https://healthunify.com/bmicalculator/
        driver.get(address);
        //2. Enter 74 in Weight field
        driver.findElement(By.name("wg")).sendKeys("74");
        //3. Enter 167 in Height field
        driver.findElement(By.name("ht")).sendKeys("167");
        //4. Click Calculate button
        driver.findElement(By.name("cc")).click();
        String actualCategoryText = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedCategoryText = "Your category is Overweight";
        //5. Chek text "Your category is Overweight" is displayed
        Assert.assertEquals(actualCategoryText, expectedCategoryText, "Incorrect category is displayed! UI shows:  " + actualCategoryText);
        driver.close();
    }


    @Test
    //This test should verify the correct entry symbol in the Weight field on the main page
    public void calculateKgCmsEnterWeightLetter() {

        //1.Open site https://healthunify.com/bmicalculator/
        driver.get(address);
        //2. Enter "l" in Weight field
        driver.findElement(By.name("wg")).sendKeys("'l'");
        //3. Enter 167 in Height field
        driver.findElement(By.name("ht")).sendKeys("167");
        //4. Click Calculate button
        driver.findElement(By.name("cc")).click();
        String actualCategoryText = driver.findElement(By.name("si")).getAttribute("value");
        String expectedCategoryText = "NaN";
        //5. Chek text "NaN" is displayed
        Assert.assertEquals(actualCategoryText, expectedCategoryText, "Incorrect symbol is displayed! UI shows:  " + actualCategoryText);
        driver.close();
    }


}