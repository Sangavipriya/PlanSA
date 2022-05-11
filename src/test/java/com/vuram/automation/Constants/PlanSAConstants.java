package com.vuram.automation.Constants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PlanSAConstants {
	
//	Test Applicants inputs,change as per the test data
	public static String AppURL ="https://uat.app.plan.sa.gov.au/suite/";
	public static String AssessmentID = "22000215";
	
//	Test Applicants constants
	public static String Username = "test.applicant1";
	public static String Password = "123456UAT";
	public static String Address = "76 SOUTH TERRACE, ADELAIDE";
	public static String Title = "Mrs";
	public static String FirstName = "Jolanda";
	public static String LastName = "Regression-Testing";
	public static String StreetAddress = "100 Angas Street";
	public static String City = "Adelaide";
	public static String State = "South Australia";
	public static String Postcode = "5000";
	public static String Phone = "0412 123 456";
	public static String Email = "Jolanda.visser@sa.gov.au";

	public static String EstimatedDevCost = "100000";
	public static String ApplicationNumber = "123456";
	public static LocalDate Date = LocalDate.now();
	public static DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	public static String Currentdate = Date.format(formatters);

	public static String DescriptionStage1 = "Regression Test Plan – Stage 1";
	public static String DescriptionStage2 = "Regression Test Plan – Stage 2";
	public static String DescriptionStage3 = "Regression Test Plan – Stage 3";
	public static String CITBReceiptNumber = "123654789";
	
//	
	public static String FilePath = "C:\\Users\\senthilgukanm\\Downloads\\Review 1.PNG";
	public static String RFIFilepath ="C:\\Users\\senthilgukanm\\Downloads\\Request for Information - Application 22000206 - Building Consent stage 1.docx";

	
}
