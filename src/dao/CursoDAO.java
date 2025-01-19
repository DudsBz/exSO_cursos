/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Curso;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ifsp
 */
public class CursoDAO {
    private Connection conn;
    
    public CursoDAO() {
        this.conn = Conexao.getConexao();
    }
    
    public void inserir(Curso c) throws Exception {
        String sql = "INSERT INTO curso(nome, periodo) VALUES (?, ?)";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getPeriodo());
            stmt.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao inserir curso: " + e.getMessage());
        }
    }
    
    public void atualizar(Curso c) throws Exception {
        String sql = "UPDATE curso SET nome = ?, periodo = ? WHERE id=?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getPeriodo());
            stmt.setInt(3, c.getId());
            stmt.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar curso: " + e.getMessage());
        }
    }
    
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM curso WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao excluir curso:" + e.getMessage());
        }
    }
    
    public Curso getCurso(int id) throws Exception {
        String sql = "SELECT * FROM curso WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Curso c = new Curso();
            
            rs.first();
            c.setId(id);
            c.setNome(rs.getString("nome"));
            c.setPeriodo(rs.getString("periodo"));
            
            return c;
        } catch (Exception e) {
            throw new Exception("Curso não encontrado");
        }
    }
}
