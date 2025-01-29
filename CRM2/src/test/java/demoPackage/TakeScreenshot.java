package demoPackage;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@SuppressWarnings({ "unused" })  // This way of taking the screenshot is deprecated
public class TakeScreenshot {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		
//		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
//		
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File("./screenshots/abc.png"));
//		driver.quit();
	}
}
