/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author fabricio
 */
public class BancoMySQL {
    
    private int Id, Idade;
    private String Nome;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public static Connection getConnection(String USER, String PASS){
    
        String ArqConfig = "conf/conf.con";
        String conteudo = Arquivo.Read(ArqConfig);
        String ADRESS = conteudo.split(";")[0];
        String PORT = conteudo.split(";")[1];
        String BANK= conteudo.split(";")[2];

        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://"+ADRESS+":"+PORT+"/"+BANK;      
        
        try {
            Class.forName(DRIVER);            
            return (Connection) DriverManager.getConnection(URL, USER, PASS);            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão!");
            throw new RuntimeException("Erro na conexao: ", ex);
        }        
    }
    
    public static void closeConnection(Connection con){
            
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro na conexao: " + ex);
        }                
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){

        closeConnection(con);
        
        try {
            
            if(stmt != null){
                stmt.close();
            }

        } catch (SQLException ex) {
            System.out.println("Erro na conexao: " + ex);
        }                
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){

        closeConnection(con, stmt);
        
        try {
            
            if(rs != null){
                rs.close();
            }

        } catch (SQLException ex) {
            System.out.println("Erro na conexao: " + ex);
        }                
    }    
    
    //Inserir dados
    public boolean Insert(String USER, String PASS, String Tabela){
    
        Connection con = getConnection(USER, PASS);
        PreparedStatement stmt = null;
        boolean ok = false;
        
        try {
            stmt = con.prepareStatement("INSERT INTO "+Tabela+" (id, nome, idade) VALUES(?, ?, ?)");
            stmt.setInt(1, Id);
            stmt.setString(2, Nome);
            stmt.setInt(3, Idade);
            
            stmt.executeUpdate();       
            
            //JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            ok = true;
            
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex);
        } finally{
            closeConnection(con, stmt);
        }       
        return ok;
    }

    //Deletar dado
    public boolean Delete(String USER, String PASS, String Tabela){
    
        Connection con = getConnection(USER, PASS);
        PreparedStatement stmt = null;
        boolean ok = false;
        
        try {
            stmt = con.prepareStatement("DELETE FROM "+Tabela+" WHERE id = ?");
            stmt.setInt(1, Id);            
            stmt.executeUpdate();       
            
            //Organizar Id
//            stmt = con.prepareStatement("SET @count = 0");            
//            stmt.executeUpdate();
//            stmt = con.prepareStatement("UPDATE `produto` SET `produto`.`id` = @count:= @count + 1");            
//            stmt.executeUpdate();
//            stmt = con.prepareStatement("ALTER TABLE `dbmercadinho`.`produto` AUTO_INCREMENT = 1");            
//            stmt.executeUpdate();            
            
            //JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            ok = true;
            
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex);
        } finally{
            closeConnection(con, stmt);
        }     
        return ok;
    }
 
    //Atualizar dados
    public boolean update(String USER, String PASS, String Tabela){
    
        Connection con = getConnection(USER, PASS);
        PreparedStatement stmt = null;
        boolean ok = false;
        
        try {
            stmt = con.prepareStatement("UPDATE "+Tabela+" SET nome = ?, idade = ? WHERE id = ?");
            stmt.setString(1, Nome);
            stmt.setInt(2, Idade);
            stmt.setInt(3, Id);
            
            stmt.executeUpdate();       
            
            //JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            ok = true;
            
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex);
        } finally{
            closeConnection(con, stmt);
        }     
        return ok;
    }      

    //Ler dado
    public boolean buscaDado(String USER, String PASS, String Tabela){

        Connection con = getConnection(USER, PASS);
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        boolean ok = false;
        
        try {            
            stmt = con.prepareStatement("SELECT * FROM "+Tabela+" WHERE id = ?;");
            stmt.setInt(1, Id);
            rs = stmt.executeQuery();
            
            if(rs.next()){                               
                Id = rs.getInt("id");
                Nome = rs.getString("nome");
                Idade = rs.getInt("idade");
            }
            ok = true;
                    
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex);
        } finally{
            closeConnection(con, stmt, rs);
        }        
        return ok;
    }
    
    //Ler dados
    public List<BancoMySQL> buscaDados(String USER, String PASS, String Tabela){

        Connection con = getConnection(USER, PASS);
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<BancoMySQL> tabelas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM "+Tabela);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                BancoMySQL bancoMySQL = new BancoMySQL();    
                
                bancoMySQL.setId(rs.getInt("id"));
                bancoMySQL.setNome(rs.getString("nome"));
                bancoMySQL.setIdade(rs.getInt("idade"));

                tabelas.add(bancoMySQL);
            }
                    
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex);
        } finally{
            closeConnection(con, stmt, rs);
        }
        
        return tabelas;
    }

    //Busca registros e salva em uma lista
    public List<BancoMySQL> buscaNomes(String USER, String PASS, String Tabela){

        Connection con = getConnection(USER, PASS);
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<BancoMySQL> tabelas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM "+Tabela+" WHERE nome LIKE ?;");
            stmt.setString(1, "%"+Nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                BancoMySQL bancoMySQL = new BancoMySQL();    
                
                bancoMySQL.setId(rs.getInt("id"));
                bancoMySQL.setNome(rs.getString("nome"));
                bancoMySQL.setIdade(rs.getInt("idade"));

                tabelas.add(bancoMySQL);
            }
                    
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex);
        } finally{
            closeConnection(con, stmt, rs);
        }
        
        return tabelas;
    }    
           
}
