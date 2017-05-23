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
    
    public ClasseDAO ()throws Exception{
        Connection conexao = ConnectionFactory.createConnection();
        opNovaColeta = conexao.prepareStatement("INSERT INTO coleta(descricao) VALUES (?)");
        opNovaLeitura = conexao.prepareCall("INSERT INTO leitura(coleta,local,leitura,unidade) values (?,?,?,?)");
        opListarColetas = conexao.prepareStatement("SELECT * FROM coleta");
        opListaColetaById = conexao.prepareStatement("SELECT * FROM coleta WHERE id = ?");
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
            opNovaLeitura.setString(2, leitura.getLocal());
            opNovaLeitura.setDouble(3, leitura.getLeitura());
            opNovaLeitura.setString(4, leitura.getUnidade());
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
    
}
