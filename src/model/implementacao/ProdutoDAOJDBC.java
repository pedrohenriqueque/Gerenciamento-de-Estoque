package model.implementacao;

import db.DB;
import db.DbException;
import db.Produto;
import model.ProdutoDAO;

import java.sql.*;
import java.util.ArrayList;


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
          PreparedStatement st = null;
           try {
               st = conn.prepareStatement("DELETE FROM Produtos"
               +" WHERE id_produto = ?");

               st.setInt(1, id);

               int rowsaffected = st.executeUpdate();

               if (rowsaffected > 0) {
                   System.out.println("Produto removido com sucesso!");
               }



           }catch (SQLException e){
               throw new DbException("Não foi possivel remover o produto");
           }finally {
               DB.closeStatement(st);
           }
    }

    @Override
    public Produto buscarProdutoPorId(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("SELECT * FROM Produtos WHERE id_produto = ?");
            st.setInt(1, id);


            rs = st.executeQuery();


            if (rs.next()) {
                Produto produto = new Produto();
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCodigo_produto(rs.getString("codigo_produto"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
                produto.setPreco_venda(rs.getDouble("preco_venda"));
                produto.setPreco_custo(rs.getDouble("preco_custo"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setData_validade(rs.getDate("data_validade"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setEstoque_minimo(rs.getInt("estoque_minimo"));

                return produto;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException("Não foi possível encontrar o produto: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public ArrayList<Produto> listarTodosProdutos() {
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            st = conn.prepareStatement("SELECT * FROM Produtos");

            rs = st.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCodigo_produto(rs.getString("codigo_produto"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
                produto.setPreco_venda(rs.getDouble("preco_venda"));
                produto.setPreco_custo(rs.getDouble("preco_custo"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setData_validade(rs.getDate("data_validade"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setEstoque_minimo(rs.getInt("estoque_minimo"));

                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new DbException("Erro ao listar produtos: " + e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

        return produtos;
    }

    public void imprimirProdutos(){
        ArrayList<Produto> produtos = listarTodosProdutos();
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}
