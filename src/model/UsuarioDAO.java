package model;

import db.Usuario;

import java.util.List;

public interface UsuarioDAO {

    void adicionarProduto(Usuario usuario);
    void atualizarProduto(Usuario usuario);
    void removerUsuario(int id);
    Usuario buscarUsuarioPorId(int id);
    List<Usuario> listarTodosUsuario();
}
