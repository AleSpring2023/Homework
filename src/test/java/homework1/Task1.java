package homework1;

import Browser.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task1 {

    @Test
    public void testScenario1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String expectedTitle = driver.getTitle();
        String actualTitle = "Web Orders Login";
        Assert.assertEquals(expectedTitle, actualTitle);

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        Thread.sleep(2000);

        WebElement passWord = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passWord.sendKeys("test");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();


        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Web Orders";
        Assert.assertEquals(actualTitle2, expectedTitle2);

        WebElement actualHeader = driver.findElement(By.xpath("//h1"));
        System.out.println(actualHeader.getText());
        System.out.println(driver.getTitle());
        String expectedHeader = "Web Orders";

        Assert.assertEquals(actualHeader.getText(), expectedHeader);

    }

    @Test
    public void testCase2() throws InterruptedException {

        /*
        Navigate to
"http://secure.smartbearsoftware.com/samples/TestCo
mplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "View all products" button
Validate "View all products" is selected
Validate header is equals to "List of Products"
Validate the url has "Products" keyword
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Thread.sleep(2000);

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");

        WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button']"));
        loginButton.click();

        WebElement viewAllProductsButton = driver.findElement(By.linkText("View all products"));
        Thread.sleep(2000);
        System.out.println(viewAllProductsButton.getText());
        viewAllProductsButton.click();

        WebElement header = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowserUtils.getText(header), "List of Products");
        System.out.println(driver.getCurrentUrl());
        String url = driver.getCurrentUrl();

        String actualUrl = "Products";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertTrue(expectedUrl.contains(actualUrl));
    }

    @Test
   /*
   Navigate to
"http://secure.smartbearsoftware.com/sample
s/TestComplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Find the links for
View all orders
View all products
Orders
Validate their href values are equals to :
"Default.aspx"
"Products.aspx"
"Process.aspx"
    */
    public void TestCase3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");

        WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        WebElement viewAllProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        viewAllProducts.click();

        WebElement allOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        WebElement allProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        WebElement orders = driver.findElement(By.xpath("//a[.='Order']"));

        String value = allOrders.getAttribute("href");
        String value1 = allProducts.getAttribute("href");
        String value2 = orders.getAttribute("href");
        Thread.sleep(2000);

        Assert.assertTrue(value.contains("Default.aspx"));
        Assert.assertTrue(value1.contains("Products.aspx"));
        Assert.assertTrue(value2.contains("Process.aspx"));

    }

    @Test
    public void Task4() throws InterruptedException {
          /*
  Navigate to
"http://secure.smartbearsoftware.com/samples/TestComplete11
/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "Order" button
Select product "Screen Saver"
Input quantity 5
Input Customer name "CodeFish IT School"
Input Street "2200 E devon"
Input City "Des Plaines"
Input State "Illinois"
Input Zip "60018"
Select MasterCard
Input card number "444993876233"
Input expiration date "03/24"
Click Process button
           */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        Thread.sleep(2000);

        WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("test");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement orderButton = driver.findElement(By.linkText("Order"));
        orderButton.click();
        Thread.sleep(2000);

        WebElement product = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        BrowserUtils.selectBy(product, "ScreenSaver", "value");
        Thread.sleep(2000);

        WebElement inputQuantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        inputQuantity.sendKeys("5");
        inputQuantity.click();
        Thread.sleep(2000);

        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");
        Thread.sleep(2000);

        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E Devon");
        Thread.sleep(2000);

        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        Thread.sleep(2000);

        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");
        Thread.sleep(2000);

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipCode.sendKeys("60018");
        Thread.sleep(2000);

        WebElement masterCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        masterCard.click();
        Thread.sleep(2000);

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");
        Thread.sleep(2000);

        WebElement expirationDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expirationDate.sendKeys("03/24");
        Thread.sleep(2000);

        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();


    }
}



