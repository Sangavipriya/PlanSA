package com.vuram.automation.Businessflows;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vuram.automation.Constants.PlanSAConstants;
import com.vuram.automation.PlanSAUtility.ReusableMethods;
import com.vuram.automation.utility.VATT;

public class C_RAAssessment extends VATT{
	@Parameters({"RAUsername","RAPassword"})
	@BeforeClass
	public void raLogin(String RAUsername, String RAPassword) throws Exception {
				ReusableMethods.raLogin(RAUsername, RAPassword);
	}
	
	@AfterClass
	public void logout() throws Exception {
		flow.Logout();
	}
	
	@Parameters({"AssessmentID","RFIexpirationDate","DropdownRefbody","DropdownReftype","RefReason",
		"IntRefType","RefRequestcomment","RecipientsNomination","RecallReason"})
	
	@Test
	public void raAssessment(String AssessmentID,String RFIexpirationDate, String DropdownRefbody,String DropdownReftype ,String RefReason,
			String IntRefType ,String RefRequestcomment,String RecipientsNomination,String RecallReason) throws Exception {
		
	flow.SelectCheckboxBasedonIndex(1);
	flow.WaitforProgressBar();
	flow.PopulateTextFieldBasedonPlaceholderText("Search", AssessmentID);
	flow.ClickSVGIconBasedonIndex(6);
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName(AssessmentID);
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("Building Consent - Stage 1");
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Start Assessment");
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("RFIs");
	flow.WaitforProgressBar();
	flow.ClickBoldLinkBasedonIndex(2);
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("Generate 'request for additional information' document");
	flow.WaitforProgressBar();
	flow.UploadFile(PlanSAConstants.RFIFilepath);
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Send Request");
	flow.WaitforProgressBar();
	flow.ClickBoldLinkBasedonIndex(1);
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("Summary");
	flow.WaitforProgressBar();
	flow.verifyExpectedTextInGrid(1, 2, 5,"Awaiting Further Information");	
	flow.ClickLinkBasedonName("Event History");
	flow.WaitforProgressBar();
	flow.ClickSectionorBoxLayout("Event Audit History");
	flow.verifyExpectedTextInGrid(1, 2, 5,"Request for more information sent to : Jolanda.visser@sa.gov.au");	
	flow.verifyExpectedTextInGrid(1, 3, 5,"Application workflow status changed to: Awaiting Further Information");	
	flow.ClickLinkBasedonName("Summary");
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("Building Consent - Stage 1");
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("Referrals");
	flow.WaitforProgressBar();
	flow.ClickBoldLinkBasedonIndex(2);
	flow.WaitforProgressBar();
	flow.SingleSelectDropDown(DropdownRefbody, "Referral body");
	flow.WaitforProgressBar();
	flow.SingleSelectDropDown(DropdownReftype, "Response type");
	flow.WaitforProgressBar();
	flow.VerifyUIFieldElements("Referral type", "Concurrence");
	flow.VerifyUIFieldElements("Referral period", "Ongoing");
	flow.SetWebText(RefReason, "Reason for Referral/Comments");
	flow.WaitforProgressBar();;
	flow.ClickButtonBasedonName("SUBMIT");
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Ok, Continue");
	flow.WaitforProgressBar();
	flow.ClickBoldLinkBasedonIndex(3);
	flow.WaitforProgressBar();
	flow.SingleSelectDropDown(IntRefType, "Internal Referral Type");
	flow.WaitforProgressBar();
	flow.SetWebText(RefRequestcomment, "Referral Request Comment");
	flow.SelectValuefromPicker(RecipientsNomination, "Nominate recipients from your organisation");
	flow.ClickButtonBasedonName("SUBMIT");
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Distribute Referrals");
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Distribute Referrals");
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("Recall Referral");
	flow.WaitforProgressBar();
	flow.SetWebText(RecallReason,"Recall reason");
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Recall Referral");
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Ok, Continue");
	flow.WaitforProgressBar();	
	flow.VerifyGridText(1, 1, 8,"Recalled");
}

}
