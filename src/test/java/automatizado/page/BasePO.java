package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/** Clase base para criação das novas PagesObjects.
Todas as pages devem ser herdadas desta classe */
public abstract class BasePO {

    /**Driver base que será usado pelas pages. */
    protected WebDriver driver;
    /**
     * Construtor base para criação da fabrica de elemntos (PageFactory).
     * @param driver Driver da pagina atual.
     */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Metodo que retorna o titulo da apgina atual
     * @return
     */
    public String obterTituloPagina(){
        return driver.getTitle();    
    }
    /**
     * Metodo que sabe escrever em qualquer WebElemnt do tipo input e dá um TAB no final.
     * @param input Input a qual será escrito no input.
     * @param texto texto que será escrito no Input.
     */
    public void escrever(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
}
