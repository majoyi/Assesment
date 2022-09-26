package MainRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RunTest {

	public RunTest() {
		// TODO Auto-generated constructor stub
	}

	
	// The is an option to choose browser Chrome , edge , 
	String sBrowser = "edge";
	String sUrl = "https://www.investec.com/";
	String Item = "cash investment rates";
	String sName = "Edwin ";
	String sSurname = "Test";
	String sEmail = "test@investec.co.za ";
	StepDefination Locator = new StepDefination();

	@Before
	public void BeforeClass() {

		Locator.OpenBrowser(sBrowser, sUrl);
	}

	@Test
	public void Test() throws InterruptedException {
		Locator.SearchItem(Item);
		Locator.AddPersonDetails(sName, sSurname, sEmail);
	}

	@After
    public void CloseBrowser() {
		Locator.Close();
	}
}
