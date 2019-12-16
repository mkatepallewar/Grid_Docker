package parallel;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class GridTest {
	public WebDriver driver=null;
	@Parameters("browser")
	@Test
	public void broweserTest(String browser) throws MalformedURLException {
		System.out.println("Google: "+ browser);
		
		DesiredCapabilities cap=null;
		
		if(browser.equals("firefox")) {
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.ANY);
		}else if(browser.equals("chrome")) {
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.ANY);
		}else if(browser.equals("iexplorer")) {
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.WINDOWS);
		}
		
		driver=new RemoteWebDriver(new URL("http://192.168.99.100:4446/wd/hub"),cap);
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Hello" +browser);
		
		
		//#password for vnc is secret
	}

}
