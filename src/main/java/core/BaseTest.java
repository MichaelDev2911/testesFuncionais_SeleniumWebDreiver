package core;





import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.LoginPage;

public class BaseTest {
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializar() {
		page.acessarTelaInicial();
		
		page.setEmail("michaelsilveira.castilho@yahoo.com.br");
		page.setSenha("seleniumide");
		page.entrar();
	}
	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
				File.separator + testName.getMethodName() + ".jpg"));
		
		if(Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver(); 
		}
	}

}
