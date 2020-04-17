/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.0.2:3306/banco";
    private static final String USER = "admin";
    private static final String PASS = "";
    
    public static Connection getConnection(){
    
        try {
            Class.forName(DRIVER);            
            return (Connection) DriverManager.getConnection(URL, USER, PASS);            
        } catch (ClassNotFoundException | SQLException ex) {
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
    public boolean Insert(String Tabela){
    
        Connection con = getConnection();
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
    public boolean Delete(String Tabela){
    
        Connection con = getConnection();
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
    public boolean update(String Tabela){
    
        Connection con = getConnection();
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
    public boolean buscaDado(String Tabela){

        Connection con = getConnection();
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
    public List<BancoMySQL> buscaDados(String Tabela){

        Connection con = getConnection();
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

    
}
