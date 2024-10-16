package model.implementacao;

import db.DB;
import db.DbException;
import db.Produto;
import model.ProdutoDAO;

import java.sql.*;
import java.util.List;

public class ProdutoDAOJDBC implements ProdutoDAO {

    private Connection conn;

    public ProdutoDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    public ProdutoDAOJDBC() {

    }

    @Override
    public void adicionarProduto(Produto produto) {
        PreparedStatement st = null;

        try {
            // SQL corrigida: Coloque a query inteira em uma única string
            st = conn.prepareStatement(
                    "INSERT INTO Produtos (nome, codigo_produto, categoria, quantidade_estoque, preco_venda, " +
                            "preco_custo, fornecedor, data_validade, descricao, estoque_minimo) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            // Configurando os parâmetros
            st.setString(1, produto.getNome());
            st.setString(2, produto.getCodigo_produto());
            st.setString(3, produto.getCategoria());
            st.setInt(4, produto.getQuantidade_estoque());
            st.setDouble(5, produto.getPreco_venda());
            st.setDouble(6, produto.getPreco_custo());
            st.setString(7, produto.getFornecedor());
            st.setDate(8, new java.sql.Date(produto.getData_validade().getTime())); // Convertendo java.util.Date para java.sql.Date
            st.setString(9, produto.getDescricao());
            st.setInt(10, produto.getEstoque_minimo());

            // Executando a query
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1); // Obtendo o ID gerado
                    produto.setId_produto(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Erro ao adicionar produto");
            }
            System.out.println("Você modificou "+rowsAffected+" linhas.");
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st); // Certifique-se de fechar o PreparedStatement corretamente
        }
    }


    @Override
    public void atualizarProduto(Produto produto) {

    }

    @Override
    public void removerProduto(int id) {

    }

    @Override
    public Produto buscarProdutoPorId(int id) {
        return null;
    }

    @Override
    public List<Produto> listarTodosProdutos() {
        return List.of();
    }
}
