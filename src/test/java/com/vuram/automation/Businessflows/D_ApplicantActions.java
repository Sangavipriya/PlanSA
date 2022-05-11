package com.vuram.automation.Businessflows;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vuram.automation.Constants.PlanSAConstants;
import com.vuram.automation.utility.VATT;

public class D_ApplicantActions extends VATT {
	@BeforeClass
	public void login() throws Exception {
		flow.OpenURL(PlanSAConstants.AppURL);
		flow.StepPassWithoutScreenshot("URL Launched");
		flow.ClickLinkBasedonIndex(1);
		flow.LoginwithUserNameandPassword(PlanSAConstants.Username,PlanSAConstants.Password );
		flow.StepPassWithoutScreenshot("Applicant Login Success");
		flow.WaitforProgressBar();
	}
	
	@AfterClass
	public void logout() throws Exception {
		flow.Logout();
	}
	@Parameters({"AssessmentID"})
	@Test
	public void applicantActions(String AssessmentID) throws Exception {
		
		flow.ClickLinkBasedonName(AssessmentID);
		flow.WaitforProgressBar();
		flow.ClickLinkBasedonIndex(3);
		flow.WaitforProgressBar();
		flow.SelectRadioButtonBasedonIndex(1);
		flow.WaitforProgressBar();
		flow.UploadFile(PlanSAConstants.FilePath);
		flow.WaitforProgressBar();
		flow.SingleSelectDropDownBasedonIndex("Referral Response","false",1);
		flow.WaitforProgressBar();
		flow.SingleSelectDropDownBasedonIndex("Referral Response","false",2);
		flow.ClickButtonBasedonName("SUBMIT");
		flow.WaitforProgressBar();
}
	
}
