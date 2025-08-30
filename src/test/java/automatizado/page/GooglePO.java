package automatizado.page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO{

    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(id = "hdtb-tls")
    public WebElement divResultadoPesquisa;

    /** Construtor para criação da pagina do Google
     * @param driver Driver da pagina do Google
     */
    public GooglePO(WebDriver driver){
        super(driver);
    }

    /*Metodo para pesquisar no google baseando no texto informado e conclindo com o enter 
     * @param texto Texto a ser pesuisado
    */
    public void pesquisar(String texto) {
    inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /*Metodo que retorna o resultado aproximado da pesquisa
     * @returna Retorna o resultado da pesquisa
     */
/*     public String obterResultadoPesquisa(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.visibilityOf(divResultadoPesquisa));
            return divResultadoPesquisa.getText();
        } catch (org.openqa.selenium.TimeoutException e) {
            String pageSource = driver.getPageSource().toLowerCase();
            if (pageSource.contains("captcha") || pageSource.contains("unusual traffic") || pageSource.contains("detected unusual")) {
                throw new RuntimeException("Captcha do Google detectado! Não é possível automatizar a busca.");
            }
            throw e;
        }
    } */

}
