import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class flipKartTest {
	
	public static void main(String[] args) {
		
		File pathToBinary = new File("C:\\Users\\mithe\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile(); 
		
		
		FirefoxOptions options = new FirefoxOptions().setBinary(new FirefoxBinary(pathToBinary));
		WebDriver newDriver = new FirefoxDriver(options);

		
		newDriver.get("https://www.flipkart.com/");
		newDriver.findElement(By.xpath("//input[@class= 'LM6RPg']")).sendKeys("Dell");
		newDriver.findElement(By.xpath("//input[@class= 'LM6RPg'])")).click();
	}
}
