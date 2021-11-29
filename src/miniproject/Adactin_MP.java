package miniproject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Adactin_MP {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lokesh M\\eclipse-workspace\\miniproject\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://adactinhotelapp.com/");
		Thread.sleep(4000);
		driver.manage().window().maximize();

		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		WebElement f1 = driver.findElement(By.id("username"));
		f1.sendKeys("Lokesh07");
		String f3 = f1.getAttribute("value");
		System.out.println(f3);

		WebElement f2 = driver.findElement(By.id("password"));
		f2.sendKeys("1E0Z50");
		String f4 = f2.getAttribute("value");
		System.out.println(f4);
		driver.findElement(By.id("login")).click();

		Thread.sleep(2000);
		System.out.println("***********************************");
		WebElement location = driver.findElement(By.id("location"));
		Select cl = new Select(location);
		cl.selectByVisibleText("Paris");
		List<WebElement> list = cl.getOptions();
 for (WebElement i : list) {
	System.out.println(i.getText());
}
 System.out.println("***********************************");
 WebElement firstSelectedOption = cl.getFirstSelectedOption();
 System.out.println(firstSelectedOption.getText());
 System.out.println("***********************************");
 List<WebElement> allSelectedOptions = cl.getAllSelectedOptions();
 for (WebElement j : allSelectedOptions) {
	System.out.println(j.getText());
}
 
		WebElement hotels = driver.findElement(By.id("hotels"));
		Select cl1 = new Select(hotels);
		cl1.selectByVisibleText("Hotel Sunshine");
		WebElement rooms = driver.findElement(By.id("room_type"));
		Select cl2 = new Select(rooms);
        cl2.selectByVisibleText("Double");

		WebElement noof_rooms = driver.findElement(By.id("room_nos"));
		Select cl3 = new Select(noof_rooms);
		cl3.selectByVisibleText("2 - Two");
		
		WebElement adult = driver.findElement(By.id("adult_room"));
		Select cl4 = new Select(adult);
		cl4.selectByVisibleText("2 - Two");
		
        WebElement child = driver.findElement(By.id("child_room"));
        Select cl5 = new Select(child);
        cl5.selectByVisibleText("1 - One");

		driver.findElement(By.id("Submit")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='radio']")).click();

		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		System.out.println("*****************************************************");
		driver.findElement(By.id("first_name")).sendKeys("Lokesh");

		driver.findElement(By.id("last_name")).sendKeys("Murugan");

		driver.findElement(By.id("address")).sendKeys("Venkateshwara nagar ramapuram , chennai-600028");

		driver.findElement(By.id("cc_num")).sendKeys("1234 4568 9876 3321");
		WebElement cards = driver.findElement(By.id("cc_type"));
		Select cl6 = new Select(cards);

		cl6.selectByVisibleText("Master Card");

		WebElement exm = driver.findElement(By.id("cc_exp_month"));
		Select cl7 = new Select(exm);

		cl7.selectByVisibleText("May");

		WebElement exd = driver.findElement(By.id("cc_exp_year"));
		Select cl8 = new Select(exd);

		cl8.selectByVisibleText("2022");

		driver.findElement(By.id("cc_cvv")).sendKeys("986");

		driver.findElement(By.id("book_now")).click();

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000);");
		Thread.sleep(3000);

		driver.findElement(By.id("my_itinerary")).click();
		Thread.sleep(3000);

		/*
		 * driver.findElement(By.id("(//input[@type='checkbox'])[2]")).click();
		 * Thread.sleep(2000);
		 * 
		 * 
		 * driver.findElement(By.id("//input[@name='cancelall']")).click();
		 * driver.switchTo().alert().dismiss();
		 */

		TakesScreenshot tt = (TakesScreenshot) driver;
		File dd = tt.getScreenshotAs(OutputType.FILE);

		File s = new File("C:\\Users\\Lokesh M\\eclipse-workspace\\miniproject\\screenshots\\adactin.png");

		FileHandler.copy(dd, s);

	}

}
