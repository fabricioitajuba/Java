/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;

/**
 *
 * @author fabricio
 */
public class ProdutoDAO {
    
    //Inserir dados
    public void create(Produto p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO produto (descricao, qtd, preco) VALUES(?, ?, ?)");
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            
            stmt.executeUpdate();       
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }        
    }
    
    //Ler dados
    public List<Produto> read(){

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQtd(rs.getInt("qtd"));
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    }

    //Procurar produto específico
    public List<Produto> readForDesc(String desc){

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQtd(rs.getInt("qtd"));
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    
    //Atualizar dados
    public void update(Produto p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE produto SET descricao = ?, qtd = ?, preco = ? WHERE id = ?");
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getId());
            
            stmt.executeUpdate();       
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }        
    }    
    
    //Deletar dados
    public void delete(Produto p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?");
            stmt.setInt(1, p.getId());            
            stmt.executeUpdate();       
            
            //Organizar Id
            stmt = con.prepareStatement("SET @count = 0");            
            stmt.executeUpdate();
            stmt = con.prepareStatement("UPDATE `produto` SET `produto`.`id` = @count:= @count + 1");            
            stmt.executeUpdate();
            stmt = con.prepareStatement("ALTER TABLE `dbmercadinho`.`produto` AUTO_INCREMENT = 1");            
            stmt.executeUpdate();            
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }        
    }                   
}
