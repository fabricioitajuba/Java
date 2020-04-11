/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import conexoes.ConexaoSQLite;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fabricio
 */
public class CriarTabelaSQLite {
    
    private final ConexaoSQLite conexaoSQLite;
    
    public CriarTabelaSQLite(ConexaoSQLite pConexaoSQLite){
        this.conexaoSQLite = pConexaoSQLite;
    }
    
    public void criarTabelaPessoa(){
        
        String sql = "CREATE TABLE IF NOT EXISTS tbl_pessoa"
                + "("
                + "id integer PRIMARY KEY,"
                + "nome text NOT NULL,"
                + "idade integer"
                + ");";
        
        //executando o sql de criar tabela
        boolean conectou = false;
            
        try{
            conectou = this.conexaoSQLite.conectar();
            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);
            System.out.println("Tabela pessoa criada!");
        }catch(SQLException e){
            //Mensagem de erro na criação da tabela
        }finally{
           if(conectou){
                this.conexaoSQLite.desconectar();
           }
        }
    }
}
