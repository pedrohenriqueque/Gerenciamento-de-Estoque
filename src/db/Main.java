package db;

import model.DaoFactory;
import model.ProdutoDAO;
import model.implementacao.ProdutoDAOJDBC;

import java.util.ArrayList;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProdutoDAO produtoDAO = DaoFactory.criarProdutoDAO();

        Produto produto = new Produto();
        produtoDAO.listarTodosProdutos();
        System.out.println(produto);
        ArrayList<Produto> produtos = produtoDAO.listarTodosProdutos();

        produtoDAO.imprimirProdutos();

    }
}