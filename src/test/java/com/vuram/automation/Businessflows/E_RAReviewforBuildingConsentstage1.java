package com.vuram.automation.Businessflows;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vuram.automation.PlanSAUtility.ReusableMethods;
import com.vuram.automation.utility.VATT;

public class E_RAReviewforBuildingConsentstage1 extends VATT{
	
	@Parameters({"RAUsername","RAPassword"})
	@BeforeClass
	public void raLogin(String RAUsername, String RAPassword) throws Exception {
				ReusableMethods.raLogin(RAUsername, RAPassword);
	}
	
	@AfterClass
	public void logout() throws Exception {
		flow.Logout();
	}
	
	@Parameters({"AssessmentID","NotificationRequiredOn","Certificateby"})
	@Test(enabled=true)
	public void raReview(String AssessmentID, String NotificationRequiredOn, String Certificateby )throws Exception {
	flow.SelectCheckboxBasedonIndex(1);
	flow.WaitforProgressBar();
	flow.PopulateTextFieldBasedonPlaceholderText("Search", AssessmentID);
	flow.ClickSVGIconBasedonIndex(6);
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName(AssessmentID);
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("Building Consent - Stage 1");
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("RFIs");
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonIndex(5);
	flow.WaitforProgressBar();
	flow.SelectRadioButtonBasedonIndex(1);
	flow.ClickButtonBasedonName("SUBMIT");
	flow.WaitforProgressBar();
	flow.ClickSectionorBoxLayout("Decision History");
	flow.WaitforProgressBar();
//	flow.VerifyTextPresentinUI("RFI Decision: All requested information provided");
//	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("Assessment Info");
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonIndex(4);
	flow.WaitforProgressBar();
	flow.ClickWebElement("9A - Healthcare building");
	flow.SetWebText("10", "Number of occupants");
	flow.SelectRadioButtonBasedonIndex(1);
	flow.WaitforProgressBar();
	flow.SingleSelectDropDown(Certificateby, "The Certificate of Occupancy will be issued by");
	flow.ClickButtonBasedonName("SUBMIT");
	flow.WaitforProgressBar();	
	flow.ClickLinkBasedonName("Required Notifications");
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonIndex(3);
	flow.WaitforProgressBar();
	flow.SelectRadioButtonBasedonIndex(1);
	flow.WaitforProgressBar();
    flow.ClickButtonBasedonName("ADD NOTIFICATION");
    flow.WaitforProgressBar();
    flow.Timeout(5000);
    ReusableMethods.addNotifications(NotificationRequiredOn);
    flow.SetWebTextBasedonPartialFieldName(" Regression Testing Stage 1 – Add Notification", "List below any additional certificates, reports");
    flow.ClickButtonBasedonName("SUBMIT");
    flow.WaitforProgressBar();
}

}

