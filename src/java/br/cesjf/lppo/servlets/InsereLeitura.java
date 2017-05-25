package br.cesjf.lppo.servlets;

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

@WebServlet(name = "InsereLeitura", urlPatterns = {"/insere-leitura.html"})
public class InsereLeitura extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Leitura leitura = new Leitura();
        
        try {
            ClasseDAO dao = new ClasseDAO();
            leitura = dao.listaLeituraPorId(id);
        } catch (Exception ex) {
            Logger.getLogger(InsereLeitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("leitura",leitura);
        request.getRequestDispatcher("/WEB-INF/insere-leitura.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Double dados = Double.parseDouble(request.getParameter("leitura"));
        
    }

}
