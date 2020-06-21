package com.absa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.absa.qa.base.TestBase;



public class AddUser extends TestBase {
	
	@FindBy(xpath="//*[@type='add']") WebElement Add;
	@FindBy(name="FirstName") WebElement Fis;
	@FindBy(name="LastName") WebElement Lasl;
	@FindBy(name="UserName") WebElement User;
	@FindBy(xpath=".//*[@type='password']")WebElement Pass;
	@FindBy(xpath=".//*[@type='radio']")WebElement Radio;
	@FindBy(name="Email") WebElement Email;
	@FindBy(name="Mobilephone") WebElement Mobile ;
	@FindBy(xpath=".//*[@class='btn btn-success']") WebElement Save;
	
	//Select os=new Select(driver.findElement(By.xpath(".//*[@name='RoleId']")));
	//os.selectByValue("0");
	
	public AddUser()
	{
	PageFactory.initElements(driver, this/*or Loginpage*/);
	
	}
	
	public void Addbutton()
	{
		Add.click();	
	}
	public void NewAddUser(String Fs,String la,String Us, String pa,String B,String Admin,String Em, String Mb)
	{
		
		
		Fis.sendKeys(Fs);
		Lasl.sendKeys(la);
		User.sendKeys(Us);
		Pass.sendKeys(pa);
		Radio.click();
		Select os=new Select(driver.findElement(By.xpath(".//*[@name='RoleId']")));
		os.selectByValue("0");
		Email.sendKeys(Em);
		Mobile.sendKeys(Mb);
		Save.click();
	}

}
