package db;

import model.DaoFactory;
import model.ProdutoDAO;
import model.implementacao.ProdutoDAOJDBC;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProdutoDAO produtoDAO = DaoFactory.criarProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Mouse Gamer Logitech");
        produto.setCodigo_produto("GS1234");
        produto.setCategoria("Eletrônicos");
        produto.setQuantidade_estoque(50);
        produto.setPreco_venda(150.00);
        produto.setPreco_custo(100.00);
        produto.setFornecedor("Tech Supplier");
        produto.setData_validade(new java.sql.Date(new java.util.Date().getTime()));
        produto.setDescricao("Mouse gamer RGB com 9 botões programáveis.");
        produto.setEstoque_minimo(10);
        produtoDAO.adicionarProduto(produto);

    }
}