/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1209;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author ifsp
 */
public class ExcluirCurso {
    
    public static void main(String[] args) {
        Connection conn = Conexao.getConexao();
        
        String sql = "DELETE FROM curso WHERE id = 3";
        
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Curso #3 excluido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
}
