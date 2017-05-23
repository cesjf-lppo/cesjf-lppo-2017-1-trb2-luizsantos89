package br.cesjf.lppo.servlets;


import br.cesjf.lppo.Leitura;
import br.cesjf.lppo.dao.ClasseDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastraLeitura", urlPatterns = {"/cadastrar-leitura.html"})
public class CadastraLeitura extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Leitura leitura = new Leitura();
        
        try {
            ClasseDAO dao = new ClasseDAO();
            leitura = dao.listLeitura(id);
        } catch (Exception ex) {
            Logger.getLogger(DetalheColeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("leitura", leitura);
        request.getRequestDispatcher("/WEB-INF/cadastra-leitura.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Leitura leitura = new Leitura();
        leitura.setId(Long.parseLong(request.getParameter("id")));
        leitura.setLeitura(Double.parseDouble(request.getParameter("leitura")));
        
        try {
            ClasseDAO dao = new ClasseDAO();
            dao.atualizaLeitura(leitura);
        } catch (Exception ex) {
            Logger.getLogger(CadastraLeitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("lista-coletas.html");
    }
}
