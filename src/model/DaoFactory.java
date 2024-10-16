package model;
import db.DB;
import db.Produto;
import model.implementacao.ProdutoDAOJDBC;

public class DaoFactory {

    public static ProdutoDAO criarProdutoDAO(){
        return new ProdutoDAOJDBC(DB.getConnection());
    }
}
