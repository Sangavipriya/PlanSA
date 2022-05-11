package com.vuram.automation.Businessflows;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vuram.automation.Constants.PlanSAConstants;
import com.vuram.automation.PlanSAUtility.ReusableMethods;
import com.vuram.automation.utility.VATT;

public class F_RADecisionforBuildingConsentStage1 extends VATT {
	@Parameters({"RAUsername","RAPassword"})
	@BeforeClass
	public void raLogin(String RAUsername, String RAPassword) throws Exception {
				ReusableMethods.raLogin(RAUsername, RAPassword);
	}
	
	@AfterClass
	public void logout() throws Exception {
		flow.Logout();
	}
	
	@Parameters({"AssessmentID","DocCategory","DocType","Decision"})
	@Test(enabled=true)
	public void raDecisionforbuildingstage1(String AssessmentID,String DocCategory,String DocType, String Decision) throws Exception {
		flow.SelectCheckboxBasedonIndex(1);
		flow.WaitforProgressBar();
		flow.PopulateTextFieldBasedonPlaceholderText("Search", AssessmentID);
		flow.ClickSVGIconBasedonIndex(6);
		flow.WaitforProgressBar();
		flow.ClickLinkBasedonName(AssessmentID);
		flow.WaitforProgressBar();
		flow.ClickLinkBasedonName("Building Consent - Stage 1");
		flow.WaitforProgressBar();
		flow.ClickLinkBasedonName("Decision");
			flow.WaitforProgressBar();
			flow.VerifyPartialTextPresentinUI("Stamped plans must be uploaded");
			flow.VerifyPartialTextPresentinUI("Confirm if Essential Safety Provisions");
			flow.VerifyPartialTextPresentinUI("Is Form 3 annual return required?");
			flow.ClickLinkBasedonName("Documents");
			flow.WaitforProgressBar();
			flow.ClickButtonBasedonName("Upload Documents");
			flow.UploadFile(PlanSAConstants.FilePath);
			flow.WaitforProgressBar();
			flow.SingleSelectDropDownBasedonIndex(DocCategory,"false",1);
			flow.WaitforProgressBar();
			flow.SingleSelectDropDownBasedonIndex(DocType,"false",2);
			flow.ClickButtonBasedonName("Save Changes");
			flow.WaitforProgressBar();
			flow.ClickLinkBasedonName("Essential Safety Provisions");
			flow.WaitforProgressBar();
			flow.ClickButtonBasedonName("Edit ESPs");
			flow.SelectRadioButtonBasedonIndex(2);
			flow.SelectRadioButtonBasedonIndex(4);
			flow.WaitforProgressBar();
			flow.ClickButtonBasedonName("Save Changes");
			flow.WaitforProgressBar();
			flow.ClickLinkBasedonName("Decision");
			flow.WaitforProgressBar();
			flow.ClickButtonBasedonName("Record Decision");
			flow.WaitforProgressBar();
			flow.SingleSelectDropDown(Decision,"Decision");
			flow.SelectRadioButtonBasedonIndex(2);
			flow.SelectRadioButtonBasedonIndex(4);
			flow.SetWebText("Testing purposes only", "Reason for not requesting endorsement");
			flow.ClickButtonBasedonName("SUBMIT");
			flow.WaitforProgressBar();
			flow.ClickBoldLinkBasedonIndex(1);
			flow.verifyExpectedTextInGrid(1, 2, 5,"Granted");
			flow.verifyExpectedTextInGrid(1, 3, 5,"In Progress");
			flow.WaitforProgressBar();	

	}
}
