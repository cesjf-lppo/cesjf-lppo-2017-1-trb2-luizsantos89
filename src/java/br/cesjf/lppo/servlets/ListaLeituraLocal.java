/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Leitura;
import br.cesjf.lppo.dao.ClasseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luizs
 */
@WebServlet(name = "ListaLeituraLocal", urlPatterns = {"/lista-por-local.html"})
public class ListaLeituraLocal extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String local = request.getParameter("local");
        List<Leitura> leituras;
        
        try {
            ClasseDAO dao = new ClasseDAO();
            System.out.println(local);
            leituras = dao.opListaLeituraPorLocal(local);
        } catch (Exception ex) {
            leituras = new ArrayList<>();
            Logger.getLogger(ListaLeituraLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("leituras",leituras);
        request.getRequestDispatcher("/WEB-INF/lista-leituras.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
