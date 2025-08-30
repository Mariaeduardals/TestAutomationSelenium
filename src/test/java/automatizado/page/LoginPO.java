package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    @FindBy(css = "body > div > form > div.alert.alert-danger.text-center.alert-dismissible > button")
    public WebElement buttonFecharMensagem;

    public LoginPO(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Metodo que obtem a mensagem disparada na tela. Retorna texto da
     */
    public String obterMensagem(){
        return this.spanMensagem.getText();
    }
/**
 * Método para realizar a ação de login
 * @param email
 * @param senha
 */
    public void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha); 

        buttonEntrar.click();
    }
}
