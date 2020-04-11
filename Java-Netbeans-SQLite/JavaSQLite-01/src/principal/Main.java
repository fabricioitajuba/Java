/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import conexoes.ConexaoSQLite;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabricio
 */
public class Main {

    public static void main(String[] args) {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        CriarTabelaSQLite criarTabelaSQLite = new CriarTabelaSQLite(conexaoSQLite);
        
        criarTabelaSQLite.criarTabelaPessoa();
        
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(1);
        pessoa1.setNome("Fabricio");
        pessoa1.setIdade(44);
        
        conexaoSQLite.conectar();
        
        String sqlInsert = "INSERT INTO tbl_pessoa ("
                + "id,"
                + "nome,"
                + "idade"
                + ") VALUES(?,?,?)"
                + ";";
        
        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        
        try{
            preparedStatement.setInt(1, pessoa1.getId());            
            preparedStatement.setString(2, pessoa1.getNome());
            preparedStatement.setInt(3, pessoa1.getIdade());
            
            int resultado = preparedStatement.executeUpdate();
            
            if(resultado == 1){
                System.out.println("Pessoa inserida!");
            }else{
                System.out.println("Pessoa não inserida!");
            }
            
        }catch(SQLException e){
            System.out.println("Pessoa não inserida!");
        }finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conexaoSQLite.desconectar();
        }
    }
    
}
