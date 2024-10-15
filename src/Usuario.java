import java.util.Objects;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String senhaUsuario;
    private enum nivelAcesso{
        ADMIN,
        FUNCIONARIO
    }

    public Usuario(int idUsuario, String nomeUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario == usuario.idUsuario && Objects.equals(nomeUsuario, usuario.nomeUsuario) && Objects.equals(senhaUsuario, usuario.senhaUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nomeUsuario, senhaUsuario);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", senhaUsuario='" + senhaUsuario + '\'' +
                '}';
    }
}
