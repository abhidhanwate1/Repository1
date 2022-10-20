package dropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class HandlingDropdownList {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\Workspace\\seleniumbasic\\executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://demo.automationtesting.in/Register.html");
//		identify dropdown list
		WebElement SkillDropdown = driver.findElement(By.id("Skills"));
		
//		create an instance of select class and pass above element into its constructor
		Select selectSkill = new Select(SkillDropdown);
		
//		check whether dropdown is multiselect dropdown or not
		System.out.println("Is dropdown is allowing you to select multiple option: "+selectSkill.isMultiple());
		
//		get default or already select option
		System.out.println("already selected option name: "+selectSkill.getFirstSelectedOption().getText());
		
//		get option count
		List<WebElement> option  = selectSkill.getOptions();
		System.out.println("Option count is: "+option.size());
		
//		get dropdown option names
		for(int i = 0;i<option.size();i++) {
			System.out.println("Option "+ i + ": "+option.get(i).getText() );
			
//			select option from dropdown
			selectSkill.selectByIndex(4);
			System.out.println("Already selected option name: "+selectSkill.getFirstSelectedOption().getText());
			//****or
			selectSkill.selectByVisibleText("Analytics");
			System.out.println("Already selected option name: "+selectSkill.getFirstSelectedOption().getText());
		}
	}

}
