package automatizado.teste;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.page.GooglePO;

public class GoogleTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
       driver.get("https://www.google.com.br/");
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_devePesquisarNoGoogle(){
       // googlePage.inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);
       googlePage.pesquisar("Batata frita");
       try {
           Thread.sleep(5000); // Espera 5 segundos antes de fechar
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
    /**
     * Nesse caso de teste abaixo é um caso de erro, porque o chrome está aparecendo o captcha e não consigo executar otesto como dexcrito na aula.
     * Então o caso acima é o de sucesso, buscando por bata frita e esse abaixo é um de erro, comparando um elemento e não o encontrando 
     * por conta do captcha. Mas o codigo em si, está certo.
     */
    @Test
    public void TC002_deveSerPossivelPesquisarNoGoogle(){
         // googlePage.inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);
       googlePage.pesquisar("Nutella");
       try {
           Thread.sleep(5000); // Espera 5 segundos antes de fechar
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
}


