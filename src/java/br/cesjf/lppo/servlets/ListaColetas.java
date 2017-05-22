package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Coleta;
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

@WebServlet(name = "ListaColetas", urlPatterns = {"/lista-coletas.html"})
public class ListaColetas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Coleta> coletas;
         
        try {
            ClasseDAO dao = new ClasseDAO();
            coletas = dao.listAll();
        } catch (Exception ex) {
            Logger.getLogger(ListaColetas.class.getName()).log(Level.SEVERE, null, ex);
            coletas = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
        
        request.setAttribute("coletas" , coletas);
        request.getRequestDispatcher("/WEB-INF/lista-coletas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
