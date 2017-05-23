package br.cesjf.lppo.dao;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.Leitura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ClasseDAO {    
    private final PreparedStatement opNovaColeta;
    private final PreparedStatement opNovaLeitura;
    private final PreparedStatement opListarColetas;
    private final PreparedStatement opListaColetaById;
    private final PreparedStatement opListaLeituraById;
    private final PreparedStatement opListarLeituras;
    private final PreparedStatement opAtualizaLeitura;
    
    public ClasseDAO ()throws Exception{
        Connection conexao = ConnectionFactory.createConnection();
        opNovaColeta = conexao.prepareStatement("INSERT INTO coleta(descricao) VALUES (?)");
        opNovaLeitura = conexao.prepareCall("INSERT INTO leitura(coleta,unidade,local) values (?,?,?)");
        opListarColetas = conexao.prepareStatement("SELECT * FROM coleta");
        opListarLeituras = conexao.prepareStatement("SELECT C.DESCRICAO, L.* FROM LEITURA AS L INNER JOIN COLETA AS C ON L.COLETA = C.ID");
        opListaLeituraById = conexao.prepareStatement("SELECT C.DESCRICAO, L.* FROM LEITURA AS L INNER JOIN COLETA AS C ON L.COLETA = C.ID WHERE L.ID = ?");
        opListaColetaById = conexao.prepareStatement("SELECT * FROM coleta WHERE id = ?");
        opAtualizaLeitura = conexao.prepareStatement("UPDATE leitura SET leitura = ?, atualizacao = CURRENT_TIMESTAMP WHERE id = ?");
    }
    
    public void cria(Coleta novaColeta) throws Exception {
        try{
        opNovaColeta.setString(1, novaColeta.getDescricao());
        opNovaColeta.executeUpdate();
        
        }catch (SQLException ex){
            throw new Exception("Erro ao gravar a coleta", ex);
        }
    }
    
    public void criaLeitura(Leitura leitura) throws Exception {
        try {
            opNovaLeitura.setLong(1, leitura.getColeta());
            opNovaLeitura.setString(2, leitura.getUnidade());
            opNovaLeitura.setString(3, leitura.getLocal());
            opNovaLeitura.executeUpdate();
        }catch (SQLException ex){
            throw new Exception("Erro ao gravar a coleta", ex);
        }
    }
        
    public List<Coleta> listAll() throws Exception {
        try {
            List<Coleta> coletas = new ArrayList<>();
            ResultSet resultado = opListarColetas.executeQuery();
            while(resultado.next()) {
                Coleta coleta = new Coleta();
                coleta.setId(resultado.getLong(1));
                coleta.setDescricao(resultado.getString(2));
                coleta.setData(resultado.getDate(3));
                coletas.add(coleta);
            }
            return coletas;
        } catch (SQLException ex) {            
            throw new Exception("Erro ao listar coletas no banco", ex);
        }
    }
    
    public Coleta listColeta(Long id) throws Exception {
        try{
            Coleta coleta = new Coleta();
            opListaColetaById.setLong(1,id);
            ResultSet resultado = opListaColetaById.executeQuery();
            coleta.setId(resultado.getLong(1));
            coleta.setDescricao(resultado.getString(2));
            coleta.setData(resultado.getDate(3));
            return coleta;
        } catch (SQLException ex){
            throw new Exception("Erro ao recuperar a coleta", ex);
        }
    }
    
    public Leitura listLeitura(Long id) throws Exception {
        try{
            Leitura leitura = new Leitura();
            opListaLeituraById.setLong(1,id);
            ResultSet resultado = opListaLeituraById.executeQuery();
            while (resultado.next()) {
                leitura.setDescricaoColeta(resultado.getString(1));
                leitura.setId(resultado.getLong(2));
                leitura.setColeta(resultado.getLong(3));
                leitura.setLocal(resultado.getString(4));
                leitura.setLeitura(resultado.getDouble(5));
                leitura.setUnidade(resultado.getString(6));
                leitura.setAtualizacao(resultado.getDate(7));
            }
            return leitura;
            
        } catch (SQLException ex){
            throw new Exception("Erro ao recuperar a coleta", ex);
        }
    }
    
    
    
    public List<Leitura> listAllLeituras() throws Exception {
        try {
            List<Leitura> leituras = new ArrayList<>();
            ResultSet resultado = opListarLeituras.executeQuery();
            while(resultado.next()) {
                Leitura leitura = new Leitura();
                leitura.setDescricaoColeta(resultado.getString(1));
                leitura.setId(resultado.getLong(2));
                leitura.setColeta(resultado.getLong(3));
                leitura.setLocal(resultado.getString(4));
                leitura.setLeitura(resultado.getDouble(5));
                leitura.setUnidade(resultado.getString(6));
                leitura.setAtualizacao(resultado.getDate(7));
                leituras.add(leitura);
            }
            return leituras;
        } catch (SQLException ex) {            
            throw new Exception("Erro ao listar coletas no banco", ex);
        }
    }
    
    public void atualizaLeitura(Leitura leitura) throws Exception {
        try {
            opAtualizaLeitura.setLong(1, leitura.getId());
            opNovaLeitura.setDouble(2, leitura.getLeitura());
            opNovaLeitura.executeUpdate();
        }catch (SQLException ex){
            throw new Exception("Erro ao gravar a coleta", ex);
        }
    }
      
}
