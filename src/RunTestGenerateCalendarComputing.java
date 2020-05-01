import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunTestGenerateCalendarComputing {
	  static WebDriver webDriver;
	    /**
	     * @param args
	     * @throws InterruptedException
	     */
	    public static void main(final String[] args) throws InterruptedException 
	    {
	       System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver");

	       webDriver = new ChromeDriver();
	       webDriver.manage().window().maximize();
	        
	       if(testCalendarButtonComputing())
	        {
	        	System.out.println("About section of the project retrieved");
	        }
	        
	        else
	        {
	        	System.out.println("Error retrieving 'About' section");
	        }
	    }
	    
	    public static boolean testCalendarButtonComputing()
	    { 
		    webDriver.navigate().to("http://historytools.herokuapp.com/");
		    
	    	WebDriverWait wait = new WebDriverWait(webDriver, 20);
	    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"generateComputing\"]")));
	    	webDriver.findElement(By.xpath("//*[@id=\"generateComputing\"]")).click();
	    	
	    	if(webDriver.findElement(By.tagName("h2")).getText().equals("Status: Currently generating..."))
	    	{
	    		return true;
	    	}
	    	else { return false; }
	   
	    }
	       

}
