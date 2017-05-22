package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.Leitura;
import br.cesjf.lppo.dao.ClasseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DetalheColeta", urlPatterns = {"/detalhe.html"})
public class DetalheColeta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = null;
                
        if (request.getParameter("id") != null || request.getParameter("id") != "null" ) {
            id = Long.parseLong(request.getParameter("id"));
        } else {
            response.sendRedirect("lista-coletas.html");
        }
        
        Coleta coleta = new Coleta();
        
        try {
            ClasseDAO dao = new ClasseDAO();
            coleta = dao.listColeta(id);
        } catch (Exception ex) {
            Logger.getLogger(DetalheColeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("coleta", coleta);
        request.getRequestDispatcher("/WEB-INF/detalhe-coleta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Coleta coleta = new Coleta();
        Leitura leitura = new Leitura();        
        
        leitura.setColeta(Long.parseLong(request.getParameter("id")));
        leitura.setLeitura(Double.parseDouble(request.getParameter("leitura")));
        leitura.setUnidade(request.getParameter("unidade"));
        leitura.setLocal(request.getParameter("local"));
        
        try {
            ClasseDAO dao = new ClasseDAO();
            dao.criaLeitura(leitura);
        } catch (Exception ex) {
            Logger.getLogger(DetalheColeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("lista-coletas.html");
    }
    
}
