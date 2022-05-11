package com.vuram.automation.Security;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.vuram.automation.utility.VATT;

public class SecurityTesting extends VATT{
	@Parameters({"SecurityTab"})
	@Test
	public void DemoMethod(String SecurityTab) throws Exception
	{
		flow.BulkSecurityTestingforSitesTasks(SecurityTab,1);
	}
}
