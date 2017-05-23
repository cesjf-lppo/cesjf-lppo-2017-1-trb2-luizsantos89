
package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.Leitura;
import br.cesjf.lppo.dao.ClasseDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaLeituras", urlPatterns = {"/lista-leituras.html"})
public class ListaLeituras extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Leitura> leituras;
         
        try {
            ClasseDAO dao = new ClasseDAO();
            leituras = dao.listAllLeituras();
        } catch (Exception ex) {
            Logger.getLogger(ListaColetas.class.getName()).log(Level.SEVERE, null, ex);
            leituras = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
        
        request.setAttribute("leituras" , leituras);
        request.getRequestDispatcher("/WEB-INF/lista-leituras.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
