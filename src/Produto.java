import java.sql.Date;
import java.util.Objects;

public class Produto {

   private int id_produto;
   private String nome;
   private String codigo_produto;
   private String categoria;
   private int quantidade_estoque;
   private double preco_venda;
   private double preco_custo;
   private String fornecedor;
   private Date data_validade;
   private String descricao;
   private int estoque_minimo;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque_minimo() {
        return estoque_minimo;
    }

    public void setEstoque_minimo(int estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_validade() {
        return data_validade;
    }

    public void setData_validade(Date data_validade) {
        this.data_validade = data_validade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(double preco_custo) {
        this.preco_custo = preco_custo;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(String codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id_produto == produto.id_produto && quantidade_estoque == produto.quantidade_estoque && Double.compare(preco_venda, produto.preco_venda) == 0 && Double.compare(preco_custo, produto.preco_custo) == 0 && estoque_minimo == produto.estoque_minimo && Objects.equals(nome, produto.nome) && Objects.equals(codigo_produto, produto.codigo_produto) && Objects.equals(categoria, produto.categoria) && Objects.equals(fornecedor, produto.fornecedor) && Objects.equals(data_validade, produto.data_validade) && Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_produto, nome, codigo_produto, categoria, quantidade_estoque, preco_venda, preco_custo, fornecedor, data_validade, descricao, estoque_minimo);
    }

    public Produto(int id_produto, String nome, String codigo_produto, String categoria, int quantidade_estoque, double preco_venda, double preco_custo, String fornecedor, Date data_validade, String descricao, int estoque_minimo) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.codigo_produto = codigo_produto;
        this.categoria = categoria;
        this.quantidade_estoque = quantidade_estoque;
        this.preco_venda = preco_venda;
        this.preco_custo = preco_custo;
        this.fornecedor = fornecedor;
        this.data_validade = data_validade;
        this.descricao = descricao;
        this.estoque_minimo = estoque_minimo;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id_produto=" + id_produto +
                ", nome='" + nome + '\'' +
                ", codigo_produto='" + codigo_produto + '\'' +
                ", categoria='" + categoria + '\'' +
                ", quantidade_estoque=" + quantidade_estoque +
                ", preco_venda=" + preco_venda +
                ", preco_custo=" + preco_custo +
                ", fornecedor='" + fornecedor + '\'' +
                ", data_validade=" + data_validade +
                ", descricao='" + descricao + '\'' +
                ", estoque_minimo=" + estoque_minimo +
                '}';
    }
}
