package model;
import db.Produto;

import java.util.List;

public interface ProdutoDAO {

        void adicionarProduto(Produto produto);
        void atualizarProduto(Produto produto);
        void removerProduto(int id);
        Produto buscarProdutoPorId(int id);
        List<Produto> listarTodosProdutos();
}
