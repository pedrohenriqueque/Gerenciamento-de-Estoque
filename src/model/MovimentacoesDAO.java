package model;
import db.Movimentacao;

import java.util.List;

public interface MovimentacoesDAO {
    void adicionarMovimentacao(Movimentacao movimentacao);
    void atualizarMovimentacao(Movimentacao movimentacao);
    void removerMovimentacao(int idMovimentacao);
    Movimentacao buscarMovimentacaoPorId(int idMovimentacao);
    List<Movimentacao> listarTodasMovimentacoes();
}
