import java.util.Observable;

public class Grupo extends Observable {
    private String nomeGrupo;
    private String descricao;
    private Integer totalNoGrupo;

    public Grupo(String nomeGrupo, String descricao, Integer totalNoGrupo) {
        this.nomeGrupo = nomeGrupo;
        this.descricao = descricao;
        this.totalNoGrupo = totalNoGrupo;
    }

    public void enviarNotificacaoGrupo() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "grupo{" +
                "Nome do Grupo: " + nomeGrupo +
                ", Descrição: " + descricao +
                ", Total de pessoas no grupo: " + totalNoGrupo +
                '}';
    }
}
