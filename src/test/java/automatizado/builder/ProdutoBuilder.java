package automatizado.builder;
import automatizado.page.ControleDeProdutosPO;

/**
 * Classe que sabe coonstuir ou adicionar um produto na tela.
 */

public class ProdutoBuilder {

    private String codigo = "00001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "26-08-2025";

    private ControleDeProdutosPO controleDeProdutosPO;

    /**
     * Construtor do produtoBuilder que recebe a pagina de controle de produtos
     */

    public ProdutoBuilder(ControleDeProdutosPO controleDeProdutosPO){
        this.controleDeProdutosPO = controleDeProdutosPO;
    }

    /**
     * Metodo que sabe adicionar um codigo ao builder. Demais abaixo desse fazem a seguem a mesma regra, de acordo com o que é adicionado no metodo.
     * @param codigo que será adicionado
     * @return retorna a própria classe ProdutoBuilder
     */

    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    /**
     * Metodo que constroi o produto, ou seja, adicona o produto pela tela de cadastro do produto.
     */
    public void builder(){

        controleDeProdutosPO.escrever(controleDeProdutosPO.inputCodigo, codigo);
        controleDeProdutosPO.escrever(controleDeProdutosPO.inputNome, nome);
        controleDeProdutosPO.escrever(controleDeProdutosPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");
        controleDeProdutosPO.escrever(controleDeProdutosPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutosPO.escrever(controleDeProdutosPO.inputData, data);

        controleDeProdutosPO.buttonSalvar.click();
    }

}
