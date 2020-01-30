import Core.APIDriverInterface;
import Core.BaseFile;
import Core.Reporting;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class RestingSoapTestRunner extends APIDriverInterface {

    static Reporting r = new Reporting();

    @Rule
    public TestName name = new TestName();

    @Before
    public void SendRequest(){
        BaseFile.tname = name.getMethodName();
        r.CreateReportFile();
        String val = MakeCallRetrieveEthereumInfo();
        r.Info(val);
    }

    @After
    public void CloseServers(){

    }

    @Test
    public void ValidateRequest(){
        System.out.println("Validation of return Json occurs here");
        r.Pass("Validation of return Json occurs here");
    }




}
