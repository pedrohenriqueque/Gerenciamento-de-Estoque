package db;

import java.sql.Date;
import java.util.Objects;

public class Movimentacao {

    private int idMovimentacao;
    private enum tipoMovimentacao {
        ENTRADA,
        SAIDA
    }
    private int movimentacao;
    private Date dataMovimentacao;
    private String usuarioResponsavel;
    private String observacao;
    private int usuariosId;
    private int produtoId;


    public Movimentacao(int idMovimentacao, int movimentacao, Date dataMovimentacao, String usuarioResponsavel, String observacao, int usuariosId, int produtoId) {
        this.idMovimentacao = idMovimentacao;
        this.movimentacao = movimentacao;
        this.dataMovimentacao = dataMovimentacao;
        this.usuarioResponsavel = usuarioResponsavel;
        this.observacao = observacao;
        this.usuariosId = usuariosId;
        this.produtoId = produtoId;
    }

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public int getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(int movimentacao) {
        this.movimentacao = movimentacao;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(String usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(int usuariosId) {
        this.usuariosId = usuariosId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public String toString() {
        return "db.Movimentacoes{" +
                "idMovimentacao=" + idMovimentacao +
                ", movimentacao=" + movimentacao +
                ", dataMovimentacao=" + dataMovimentacao +
                ", usuarioResponsavel='" + usuarioResponsavel + '\'' +
                ", observacao='" + observacao + '\'' +
                ", usuariosId=" + usuariosId +
                ", produtoId=" + produtoId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimentacao that = (Movimentacao) o;
        return idMovimentacao == that.idMovimentacao && movimentacao == that.movimentacao && usuariosId == that.usuariosId && produtoId == that.produtoId && Objects.equals(dataMovimentacao, that.dataMovimentacao) && Objects.equals(usuarioResponsavel, that.usuarioResponsavel) && Objects.equals(observacao, that.observacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMovimentacao, movimentacao, dataMovimentacao, usuarioResponsavel, observacao, usuariosId, produtoId);
    }
}


