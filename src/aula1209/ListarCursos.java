/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1209;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author ifsp
 */
public class ListarCursos {
    
    public static void main(String[] args) {
        Connection conn = Conexao.getConexao();
        
        String sql = "SELECT * FROM curso";
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            //percorrer o rs para listar cada curso retornado
            while(rs.next()) {
                String imp = rs.getString("nome") + " - " + rs.getString("periodo");
                System.out.println(imp);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar cursos: " + e.getMessage());
        }
    }
}
