
import dao.FilmeDAO;
import bean.Filme;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Logan Michel
 */
public class FilmesDAOJUnitTest {

    FilmeDAO filmeDAO = new FilmeDAO();

    @Test
    public void testarCadastro() {
        Filme avatar = new Filme();
        avatar.setNome("Avatar");
        avatar.setDiretor("James Cameron");
        avatar.setCategoria("Ação");
        avatar.setAtorPrincipal("Sam Worthington");
        avatar.setIdiomaOriginal("Inglês");
        avatar.setFaixaEtaria("12 anos");
        avatar.setAno((short) 2009);
        avatar.setLegenda(true);
        avatar.setDublado(true);
        avatar.setOrcamento(1_000_000);
        avatar.setFaturamento(999_000_000);
        avatar.setTempoFilme((short) 280);

        int identificador = filmeDAO.cadastrar(avatar);

        assertNotSame(identificador, -1);

        Filme filmeBuscado = filmeDAO.obterPeloId(identificador);

        assertEquals(avatar.getNome(), filmeBuscado.getNome());
        assertEquals(avatar.getDiretor(), filmeBuscado.getDiretor());
        assertEquals(avatar.getCategoria(), filmeBuscado.getCategoria());
        assertEquals(avatar.getAtorPrincipal(), filmeBuscado.getAtorPrincipal());
        assertEquals(avatar.getIdiomaOriginal(), filmeBuscado.getIdiomaOriginal());
        assertEquals(avatar.getFaixaEtaria(), filmeBuscado.getFaixaEtaria());
        assertEquals(avatar.isLegenda(), filmeBuscado.isLegenda());
        assertEquals(avatar.isDublado(), filmeBuscado.isDublado());
        assertEquals(avatar.getOrcamento(), filmeBuscado.getOrcamento(), 0);
        assertEquals(avatar.getFaturamento(), filmeBuscado.getFaturamento(), 0);
        assertEquals(avatar.getTempoFilme(), filmeBuscado.getTempoFilme());
        assertEquals(avatar.getAno(), filmeBuscado.getAno());

    }

}
