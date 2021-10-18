import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    void reportarUmaNotificacaoGrupo() {
        Grupo grupo = new Grupo("Familia", "Grupo da familia Silva", 22);
        Usuario usuario = new Usuario("Marco Vinicius");
        usuario.entrarGrupo(grupo);
        grupo.enviarNotificacaoGrupo();
        assertEquals("Marco Vinicius acabou de entrar no grupo{Nome do Grupo: Familia, Descrição: Grupo da familia Silva, Total de pessoas no grupo: 22}", usuario.getNotificacaoGrupo(grupo));
    }

    @Test
    void reportarNotificacoesGrupo() {
        Grupo grupo = new Grupo("Familia", "Grupo da familia Silva", 22);
        Usuario usuario1 = new Usuario("Marina Silva");
        Usuario usuario2 = new Usuario("João Silva");
        usuario1.entrarGrupo(grupo);
        usuario2.entrarGrupo(grupo);
        grupo.enviarNotificacaoGrupo();
        assertEquals("Marina Silva acabou de entrar no grupo{Nome do Grupo: Familia, Descrição: Grupo da familia Silva, Total de pessoas no grupo: 22}", usuario1.getNotificacaoGrupo(grupo));
        assertEquals("João Silva acabou de entrar no grupo{Nome do Grupo: Familia, Descrição: Grupo da familia Silva, Total de pessoas no grupo: 22}", usuario2.getNotificacaoGrupo(grupo));
    }

    @Test
    void naoDeveReportarUmaNotificacaoGrupo() {
        Grupo grupo = new Grupo("Familia", "Grupo da familia Silva", 22);
        Usuario usuario1 = new Usuario("Marco Vinicius");
        grupo.enviarNotificacaoGrupo();
        assertEquals(null, usuario1.getNotificacaoGrupo(grupo));
    }

    @Test
    void deveReportarGrupo1() {
        Grupo grupo1 = new Grupo("Familia", "Grupo da familia Silva", 22);
        Grupo grupo2 = new Grupo("Amigos", "Grupo da amigos", 12);
        Usuario usuario1 = new Usuario("Marina Silva");
        Usuario usuario2 = new Usuario("João Silva");
        usuario1.getNotificacaoGrupo(grupo1);
        usuario2.getNotificacaoGrupo(grupo2);
        grupo1.enviarNotificacaoGrupo();
        assertEquals("Marco Vinicius acabou de entrar no grupo{Nome do Grupo: Familia, Descrição: Grupo da familia Silva, Total de pessoas no grupo: 22}", usuario1.getNotificacaoGrupo(grupo1));
        assertEquals(null, usuario2.getNotificacaoGrupo(grupo2));
    }
}
