package com.vuram.automation.PlanSAUtility;

import org.openqa.selenium.By;
import com.vuram.automation.Constants.PlanSAConstants;
import com.vuram.automation.utility.VATT;

public class ReusableMethods extends VATT {

	public static void raLogin(String RAUsername, String RAPassword) throws Exception {
		flow.StepInfoWithoutScreenshot("Logging in as RA user "+RAUsername+" for the Assessment");
		flow.OpenURL(PlanSAConstants.AppURL);
		flow.ClickLinkBasedonIndex(2);
		flow.WaitforProgressBar();
	    flow.PopulateTextFieldBasedonPlaceholderText("Email, phone, or Skype",RAUsername);
	    flow.WaitforProgressBar();
	    owebdriver.findElement(By.xpath("//input[@value=\"Next\"]")).click();
    	flow.PopulateTextFieldBasedonPlaceholderText("Password",RAPassword);
    	owebdriver.findElement(By.xpath("//input[@value=\"Sign in\"]")).click();
    	flow.WaitforProgressBar();
    	owebdriver.findElement(By.xpath("//input[@value=\"No\"]")).click();
		flow.WaitforProgressBar();

}

	public static void expirationDateRFI(String RFIexpirationDate) throws Exception {
		flow.VerifyTextPresentinUI("abcd");
		flow.ClickSVGIconBasedonIndex(8);
		flow.ClickButtonBasedonName("CLEAR");
		flow.ClearField("RFI Expiration Date");
		flow.Timeout(3000);	
		flow.PopulateDateFieldBasedonPlaceholderText("dd/mm/yyyy",RFIexpirationDate);
		
	}
	
	public static void addNotifications(String NotificationRequiredOn ) {
		 owebdriver.findElement(By.xpath("(//input[@placeholder=\"eg: framing\"])[4]")).sendKeys("Regression Testing – First Stage");
		 owebdriver.findElement(By.xpath("(//label[contains(text(),'"+NotificationRequiredOn+"')])[4]")).click();

	}

}
