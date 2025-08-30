package automatizado.teste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todas as classes de teste.
 */

public abstract class BaseTest {

    /** Driver do navegador da pagina inicial */
    protected static WebDriver driver;
    /** Caminho base da URL do sistema testado */
    private static final String URL_BASE = "file:///C:/Users/eduar/Downloads/controle-de-produtos%20(1)/sistema/login.html";
    /** Caminho relativo do driver ao projeto refente ao path */
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver.exe";

    /**
     * Método que inicializa o driver no navegador antes de qualquer classe de teste
     */
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /**
     * Método que finaliza o driver no navegador após a execução de todos os testes
     */
    @AfterClass
    public static void finalizar(){
        driver.quit();
    }
}
