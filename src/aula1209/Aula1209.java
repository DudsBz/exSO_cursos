/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula1209;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author ifsp
 */
public class Aula1209 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = Conexao.getConexao();
        
        String sql = "INSERT INTO curso (nome, periodo) VALUES ('Quimica', 'Matutino')";
        
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Novo curso adicionado");
        } catch (Exception e) {
            System.out.println("Erro ao add curso: " + e.getMessage());
        }
        
    }
    
}
