package automatizado.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automatizado.Model.ProdutoTabela;

public class ControleDeProdutosPO extends BasePO {  

    //#region WebElements
    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(id = "ul>li>a.nav-link")
    public WebElement linkVoltar;

    @FindBy(css = "div.modal-header>h4")
    public WebElement tituloModal;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    @FindBy(css = "body>nav>a")
    public WebElement logoControleProdutos;

    @FindBy(css = "#collapsibleNavbar>ul>li>a")
    public WebElement buttonVoltar;

    @FindBy(css = "table tbody tr")
    public List<WebElement> linhasTabela;  

    @FindBy(css = "#cadastro-produto > div > div > div.modal-header > button.close")
    public WebElement buttonFecharModal;

    @FindBy(css = "#cadastro-produto > div > div > div.modal-body > div.alert.alert-danger.text-center.alert-dismissible > button.close")
    public WebElement buttonFecharAlerta;

    @FindBy(id = "mensagem")
    public WebElement mensagemAlerta;

    @FindBy(css = "table thead th")
    public List<WebElement> titulosTabela;

    //#endregion WebElements

    public ControleDeProdutosPO(WebDriver driver) {
        super(driver);
    }

    public void cadastrarProduto(String codigo, String nome, Integer quantidade, Double valor, String data){

        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade.toString());
        escrever(inputValor, valor.toString());
        escrever(inputData, data);

        buttonSalvar.click();
    }

    // já não é mais necessário, pois agora usamos o produto builder e para usar aqui poderia ser feito igual fizemos no controle de produtos diretamente.
   // public void cadastrarProduto(ProdutoBuilder produtoBuilder){

    //    escrever(inputCodigo, produtoBuilder.codigo);
    //    escrever(inputNome, produtoBuilder.nome);
    //    escrever(inputQuantidade, produtoBuilder.quantidade.toString());
    //    escrever(inputValor, produtoBuilder.valor.toString());
    //    escrever(inputData, produtoBuilder.data);

   //     buttonSalvar.click();
  //  }


    public List<ProdutoTabela> obterProdutosDaTabela() {
    List<ProdutoTabela> produtos = new ArrayList<>();
    for (WebElement linha : linhasTabela) {
        List<WebElement> colunas = linha.findElements(By.tagName("td"));
        // Supondo que a ordem das colunas seja: código, nome, quantidade, valor, data
        produtos.add(new ProdutoTabela(
            colunas.get(0).getText(),
            colunas.get(1).getText(),
            colunas.get(2).getText(),
            colunas.get(3).getText(),
            colunas.get(4).getText()
        ));
    }
    return produtos;
}
}
