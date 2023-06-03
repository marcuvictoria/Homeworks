package SeleniumHomework;

import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework1 {
    @Test
    public void homework1(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

       String actualTitle = driver.getTitle().trim();
       String expectedTitle ="Web Orders Login".trim();
       Assert.assertEquals(actualTitle,expectedTitle);

       WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
       username.sendKeys("Tester");
       WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
       password.sendKeys("test");
       WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
       loginButton.click();

       String secondTitle = driver.getTitle();
       String expectedSecondTitle = "Web Orders";
       Assert.assertEquals(secondTitle,expectedSecondTitle);

       WebElement header = driver.findElement(By.tagName("h2"));

       Assert.assertEquals(BrowserUtils.getText(header),"List of All Orders");
    }
    @Test
    public void homework2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement viewAllProducts = driver.findElement(By.linkText("View all products"));
        viewAllProducts.click();
        Thread.sleep(2000);
        viewAllProducts = driver.findElement(By.linkText("View all products"));
        String actualText = BrowserUtils.getText(viewAllProducts);
        String expectedText ="View all products";
        Assert.assertEquals(actualText,expectedText);

        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header),"List of Products");

        String url ="http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx";
        Assert.assertTrue(url.contains("Products"));

    }
    @Test
    public void homework3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();


        WebElement viewAllOrders = driver.findElement(By.linkText("View all orders"));
        WebElement viewAllProducts = driver.findElement(By.linkText("View all products"));
        WebElement order = driver.findElement(By.linkText("Order"));

        String allOrders = viewAllOrders.getAttribute("href");
        System.out.println(allOrders);
        //don't know how
    }
    @Test
    public void homework4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement order = driver.findElement(By.linkText("Order"));
        order.click();

        WebElement product = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        BrowserUtils.selectBy(product,"ScreenSaver", "value");
        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        customerName.sendKeys("CodeFish It School");
        WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zip.sendKeys("60018");
        WebElement card = driver.findElement(By.xpath("//input[@value='MasterCard']"));
        card.click();
        WebElement cardNr = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        cardNr.sendKeys("444993876233");
        WebElement expireDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        expireDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.linkText("Process"));
        processButton.click();
        WebElement message = driver.findElement(By.tagName("strong"));
        Assert.assertEquals(BrowserUtils.getText(message),"New order has been successfully added.");

        WebElement viewAllOrders = driver.findElement(By.linkText("View all orders"));
        viewAllOrders.click();

        List<WebElement> newOrder = driver.findElements(By.xpath("//html//body//div[3]//table//tr[2]//td"));
        List<String> actualInput = new ArrayList<>();
        List<String> expectedInput = Arrays.asList("CodeFish It School","ScreenSaver","5","06/03/2023","2200 E devon","Des Plaines",
        "Illinois","60018","MasterCard","444993876233","03/24");
        for (int i =0;i<newOrder.size();i++){
            actualInput.add(BrowserUtils.getText(newOrder.get(i)));

        }
        Assert.assertEquals(actualInput,expectedInput);






    }


    }
