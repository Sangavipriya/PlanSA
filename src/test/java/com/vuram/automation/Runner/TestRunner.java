package com.vuram.automation.Runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.vuram.automation.support.Dynamicxmlcreation;
import com.vuram.automation.utility.VATTReport;
import com.vuram.automation.Constants.Constants;

public class TestRunner extends Dynamicxmlcreation {
	public List<HashMap<String, String>> mydata = new ArrayList<HashMap<String, String>>();
	public HashMap<String, String> testcase = new HashMap<String, String>();
	public List<XmlSuite> mySuites = null;
	public List<XmlTest> myTests = new ArrayList<XmlTest>();

	// Run it as java application to kick start the execution and don't change anything here
	public static void main(String args[]) throws Exception { 
		omxl.runTestNGTest(Constants.Excelfilepath, Constants.sheetname,Constants.sheetnameforOutput,Constants.xmlfilename, Constants.Suitename, Constants.screenshotfolderpath,
				Constants.reportfolderpath,Constants.Directorypath,Constants.JiraIntegration,Constants.JiraID,Constants.Jiraapitoken,Constants.JiraDomainURL,Constants.JiraassigneeaccountID,Constants.Jiraprojectkey,
				Constants.EmailIntegration, Constants.Subject,Constants.BodyMessage, Constants.fromaddress, 
				Constants.Toaddress, Constants.Ccaddress, Constants.apppassword,Constants.Platform);

		List<String>result=new ArrayList<String>();
		for(Map.Entry<String, String>entry:VATTReport.Testcaseresult.entrySet())
		{
			if(entry.getValue().equalsIgnoreCase("Fail"))
			{
				result.add(entry.getKey());
			}
		}
		if(!result.isEmpty())
		{
			StringBuilder RESULTString=new StringBuilder();
			for(String list:result)
			{
				RESULTString.append(list);
				RESULTString.append(System.lineSeparator());
			}
			throw new Exception("Pipeline Build with the status 1 and we have error in the run - "+RESULTString.toString());
		}
	}
}
