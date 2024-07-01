package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }
    @Test
    public  void testCase01() throws InterruptedException{
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Start Test case: testCase01");
        // driver.get("https://www.google.com");
        // opening the url
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        // thread.sleep for 5 sec
        
        Thread.sleep(6000);
    

        // Entering the name
       WebElement name= driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf' and @aria-describedby='i2 i3']"));

        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOf(name));
        name.sendKeys("Crio Learner");
        // Entering why are you practicing selenium

        long currentTimestamp = System.currentTimeMillis();

        String yourAnswer = "I want to be the best QA Engineer!";
        driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']")).sendKeys(yourAnswer+currentTimestamp);
        Thread.sleep(5000);
        // How much experience do you have in Automation Testing? radio button
        WebElement radioButton = driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[1]"));
        if(!radioButton.isSelected()){
            radioButton.click();
        }
        WebElement javaCheckbox = driver.findElement(By.xpath("//div[@id='i30']"));
      

        javaCheckbox.click();
        Thread.sleep(5000);
        WebElement seleniumCheckBox = driver.findElement(By.xpath("//div[@id='i33']"));
        seleniumCheckBox.click();
        Thread.sleep(5000);
        WebElement testngCheckBox = driver.findElement(By.xpath("//div[@id='i39']"));
        testngCheckBox.click();
        Thread.sleep(5000);
        WebElement howToAddressYouDropDown = driver.findElement(By.xpath("//span[text()='Choose']"));
        howToAddressYouDropDown.click();
        Thread.sleep(5000);
        // Select select = new Select(howToAddressYouDropDown);
        // select.selectByVisibleText("Mr");
        WebElement mr = driver.findElement(By.xpath("(//span[text()='Mr'])[2]"));
        mr.click();
        Thread.sleep(5000);
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysBefore = today.minusDays(7);
        System.out.println(sevenDaysBefore);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateToSelect = sevenDaysBefore.format(formatter);
        WebElement datePicker = driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf' and @max='2074-01-01']"));
        Thread.sleep(2000);
        datePicker.sendKeys(dateToSelect);
        Thread.sleep(2000);
        LocalTime time = LocalTime.now();
        String hour = LocalTime.now().format(DateTimeFormatter.ofPattern("HH"));
        String minute = LocalTime.now().format(DateTimeFormatter.ofPattern("mm"));
        WebElement hourField = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        WebElement minuteField = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        hourField.sendKeys(hour);
        Thread.sleep(2000);
        minuteField.sendKeys(minute);


        driver.get("https://www.amazon.in/");
        Thread.sleep(5000);

        driver.switchTo().alert().dismiss();

        Thread.sleep(5000);

        WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));

        Thread.sleep(5000);

        submit.click();

        WebElement thanks = driver.findElement(By.xpath("//div[contains(text(),'Thanks')]"));

        String thanksMsg = thanks.getText();

        System.out.println(thanksMsg);

        
        System.out.println("Test case passed ");

        System.out.println("end Test case: testCase01");

    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}