package com.vuram.automation.Businessflows;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.vuram.automation.utility.VATT;
import com.vuram.automation.PlanSAUtility.*;
public class B_RAVerification extends VATT{
	@Parameters({"RAUsername","RAPassword"})
	@BeforeClass
	public void raLogin(String RAUsername, String RAPassword) throws Exception {
				ReusableMethods.raLogin(RAUsername, RAPassword);
	}
	
	@AfterClass
	public void logout() throws Exception {
		flow.Logout();
	}
	
	@Parameters({"AssessmentID","raDropDownReason","raDropDownClassification","RiseinStoreys","TotalFloorArea"})
	
	@Test
	public void verifyConsent(String AssessmentID,String raDropDownReason,String raDropDownClassification,String RiseinStoreys,String TotalFloorArea) throws Exception {
		
		flow.SelectCheckboxBasedonIndex(1);
		flow.WaitforProgressBar();
		flow.PopulateTextFieldBasedonPlaceholderText("Search", AssessmentID);
		flow.ClickSVGIconBasedonIndex(6);
		flow.WaitforProgressBar();
		flow.ClickLinkBasedonName(AssessmentID);
		flow.ClickLinkBasedonName("Building Consent - Stage 1");
		flow.WaitforProgressBar();
		flow.ClickButtonBasedonName("Verify Consent");
		flow.WaitforProgressBar();
		flow.SelectRadioButtonBasedonIndex(1);
		flow.SingleSelectDropDown(raDropDownReason, "Reason");
		flow.ClickButtonBasedonName("NEXT");
    	flow.WaitforProgressBar();
		flow.verifyExpectedTextInGrid(1, 1, 1,"* Review 1.png");
		flow.verifyExpectedTextInGrid(1, 1, 2,"Decision Notification Form");
		flow.verifyExpectedTextInGrid(1, 2, 1,"* Review 1.png");
		flow.verifyExpectedTextInGrid(1, 1, 2,"Stamped Plans");
		flow.verifyExpectedTextInGrid(1, 1, 2,"* Review 1.png");
		flow.verifyExpectedTextInGrid(1, 1, 2,"CITB Payment Reference");
		flow.SelectRadioButtonBasedonIndex(1);
		flow.WaitforProgressBar();
		flow.ClickButtonBasedonName("NEXT");
    	flow.WaitforProgressBar();
    	flow.SelectRadioButtonBasedonIndex(1);
		flow.WaitforProgressBar();
		flow.ClickButtonBasedonName("NEXT");
    	flow.WaitforProgressBar();
    	flow.SetWebText("First stage of Regression Test Plan", "Short Description");
    	flow.SetWebText("Automated Regression Testing", "Description");
    	flow.SingleSelectDropDown(raDropDownClassification, "Classification");
    	flow.WaitforProgressBar();
    	flow.SetWebText(RiseinStoreys, "Rise in Storeys");
    	flow.SetWebText(TotalFloorArea, "Total Floor Area (m²)");
    	flow.WaitforProgressBar();
    	flow.ClickButtonBasedonName("NEXT");
    	flow.WaitforProgressBar();
    	flow.ClickButtonBasedonName("NEXT");
    	flow.WaitforProgressBar();
    	flow.verifyExpectedTextInGrid(2, 1, 2,"Regression Test Plan – Stage 1");
    	flow.Timeout(2000);
    	flow.ClickButtonBasedonName("SUBMIT");
    	flow.WaitforProgressBar();
    	flow.ClickPartialLinkBasedonName("Development application");
    	flow.VerifyTextPresentinUI("Commence Assessment");
	}	
}