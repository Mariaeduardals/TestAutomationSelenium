package automatizado.Model;

public class ProdutoTabela {
    public String codigo;
    public String nome;
    public String quantidade;
    public String valor;
    public String data;

    public ProdutoTabela(String codigo, String nome, String quantidade, String valor, String data){
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.data = data;
    }
}
