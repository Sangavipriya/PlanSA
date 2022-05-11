package com.vuram.automation.Businessflows;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vuram.automation.Constants.PlanSAConstants;
import com.vuram.automation.PlanSAUtility.ReusableMethods;
import com.vuram.automation.utility.VATT;

public class G_RADecisionforDevelopmentApproval extends VATT {
	@Parameters({"RAUsername","RAPassword"})
	@BeforeClass
	public void raLogin(String RAUsername, String RAPassword) throws Exception {
				ReusableMethods.raLogin(RAUsername, RAPassword);
	}
	
	@AfterClass
	public void logout() throws Exception {
		flow.Logout();
	}
	
	@Parameters({"AssessmentID","BcaClassification","FrameMaterial","WallMaterial","RoofMaterial","StructureType"})
	@Test(enabled=true)
	public void raDecisionStagedDA(String AssessmentID,String BcaClassification,String FrameMaterial ,String WallMaterial,String RoofMaterial,String StructureType ) throws Exception {
	
	flow.SelectCheckboxBasedonIndex(1);
	flow.WaitforProgressBar();
	flow.PopulateTextFieldBasedonPlaceholderText("Search", AssessmentID);
	flow.ClickSVGIconBasedonIndex(6);
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName(AssessmentID);
	flow.ClickPartialLinkBasedonName("Staged Development Approval for:");
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Grant Development Approval");
	flow.VerifyPartialTextPresentinUI("Stamped Plans-Dev Approval  must be uploaded");
	flow.VerifyPartialTextPresentinUI("Please ensure building statistics are updated");
	flow.ClickLinkBasedonName("Documents");	
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Upload Documents");
	flow.UploadFile(PlanSAConstants.FilePath);
	flow.WaitforProgressBar();
	flow.SingleSelectDropDownBasedonIndex("Plans","false",1);
	flow.WaitforProgressBar();
	flow.SingleSelectDropDownBasedonIndex("Stamped Plans - Dev Approval","false",2);
	flow.ClickButtonBasedonName("Save Changes");
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("Statistics");	
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Update Building Statistics");
	flow.WaitforProgressBar();
	flow.SelectCheckboxBasedonIndex(1);
	flow.WaitforProgressBar();
	flow.SelectCheckboxBasedonIndex(10);
	flow.WaitforProgressBar();
	flow.SingleSelectDropDown(BcaClassification, "Primary BCA Classification");
	flow.SingleSelectDropDown(FrameMaterial, "Frame material");
	flow.WaitforProgressBar();
	flow.SingleSelectDropDown(WallMaterial, "Wall material");
	flow.WaitforProgressBar();
	flow.SingleSelectDropDown(RoofMaterial, "Roof material");
	flow.WaitforProgressBar();
	flow.SingleSelectDropDown(StructureType, "Structure detached (free standing) or attached to another building or structure");
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("SUBMIT");
	flow.WaitforProgressBar();
	flow.ClickLinkBasedonName("Decision");
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Grant Development Approval");
	flow.SelectRadioButtonBasedonIndex(1);
	flow.WaitforProgressBar();
	flow.ClickButtonBasedonName("Generate Development Approval");
	flow.WaitforProgressBar();
	flow.ClickBoldLinkBasedonIndex(1);
	flow.WaitforProgressBar();
	flow.Timeout(5000);
	flow.verifyExpectedTextInGrid(1, 3, 5,"Granted");
	String status = flow.RetrieveTextPresentinGrid(1, 3, 5);
	System.out.println(status);
}

}
