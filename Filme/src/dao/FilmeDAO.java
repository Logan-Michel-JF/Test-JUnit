package dao;

import bean.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Logan michel
 */
public class FilmeDAO {
    
    public FilmeDAO(){
    }

    public int cadastrar(Filme filme){
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO filmes"
                    + "(nome, diretor, categoria, ano, atorPrincipal, tempoFilme, "
                    + "orcamento, faturamento, faixaEtaria, legenda, dublado, idiomaOriginal)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                int posicao = 1;
                ps.setString(posicao++, filme.getNome());
                ps.setString(posicao++, filme.getDiretor());
                ps.setString(posicao++, filme.getCategoria());
                ps.setShort(posicao++, filme.getAno());
                ps.setString(posicao++, filme.getAtorPrincipal());
                ps.setShort(posicao++, filme.getTempoFilme());
                ps.setDouble(posicao++, filme.getOrcamento());
                ps.setDouble(posicao++, filme.getFaturamento());
                ps.setString(posicao++, filme.getFaixaEtaria());
                ps.setBoolean(posicao++, filme.isLegenda());
                ps.setBoolean(posicao++, filme.isDublado());
                ps.setString(posicao++, filme.getIdiomaOriginal());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                Conexao.desconectar();
            }
        }
        return -1;
    }

    public Filme obterPeloId(int identificador) {
        Connection conexao = Conexao.conectar();
        if(conexao != null){
            String sql = "SELECT * FROM filmes WHERE id = ?";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, identificador);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Filme filme = new Filme();
                    filme.setId(rs.getInt("id"));
                    filme.setNome(rs.getString("nome"));
                    filme.setDiretor(rs.getString("diretor"));
                    filme.setCategoria(rs.getString("categoria"));
                    filme.setAtorPrincipal(rs.getString("atorPrincipal"));
                    filme.setIdiomaOriginal(rs.getString("idiomaOriginal"));
                    filme.setFaixaEtaria(rs.getString("faixaEtaria"));
                    filme.setLegenda(rs.getBoolean("legenda"));
                    filme.setDublado(rs.getBoolean("dublado"));
                    filme.setOrcamento(rs.getDouble("orcamento"));
                    filme.setFaturamento(rs.getDouble("faturamento"));
                    filme.setTempoFilme(rs.getShort("tempoFilme"));
                    filme.setAno(rs.getShort("ano"));
                    return filme;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                Conexao.desconectar();
            }
            
        }
        return null;
    }
    
    public boolean alterar(Filme )
    
}
