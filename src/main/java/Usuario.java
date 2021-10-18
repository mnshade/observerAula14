import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {
    private String nome;
    private String notificacaoGrupo;

    public Usuario(String nome){
        this.nome = nome;
    }

    public String getNotificacaoGrupo(Grupo grupo2){
        return this.notificacaoGrupo;
    }
    public void entrarGrupo(Grupo grupo){
        grupo.addObserver(this);

    }
    public void update(Observable grupo, Object arg1){
        this.notificacaoGrupo = this.nome + " acabou de entrar no " + grupo.toString();
    }
}
