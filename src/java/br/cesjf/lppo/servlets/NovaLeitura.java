
package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Coleta;
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

@WebServlet(name = "NovaLeitura", urlPatterns = {"/nova-leitura.html"})
public class NovaLeitura extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Coleta> coletas = new ArrayList();
        
        try {
            ClasseDAO dao = new ClasseDAO();
            coletas = dao.listAll();
        } catch (Exception ex) {
            Logger.getLogger(NovaLeitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("coletas", coletas);
        request.getRequestDispatcher("/WEB-INF/nova-leitura.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Leitura leitura = new Leitura();
        leitura.setColeta(Long.parseLong(request.getParameter("coleta")));
        leitura.setUnidade(request.getParameter("unidade"));
        leitura.setLocal(request.getParameter("local"));
        try {
            ClasseDAO dao = new ClasseDAO();
            dao.criaLeitura(leitura);
        } catch (Exception ex) {
            Logger.getLogger(NovaLeitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        response.sendRedirect("lista-leituras.html");
    }
}
