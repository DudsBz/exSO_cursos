/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1209;

import beans.Curso;
import dao.CursoDAO;

/**
 *
 * @author ifsp
 */
public class InserirCurso {
   
    public static void main(String[] args) {
        Curso c = new Curso();
        c.setNome("Técnico em Infomática");
        c.setPeriodo("Integral");
        
        CursoDAO cursoDAO = new CursoDAO();
        try {
            cursoDAO.inserir(c);
            System.out.println("Curso inserido com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
