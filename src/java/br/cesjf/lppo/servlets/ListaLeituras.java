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

@WebServlet(name = "ListaLeituras", urlPatterns = {"/lista-leituras.html"})
public class ListaLeituras extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long coleta = null;
        if (request.getParameter("coleta")!=null) {
            coleta = Long.parseLong(request.getParameter("coleta"));
        }
        
        String local = request.getParameter("local");
        List<Leitura> leituras;
        
        if(local==null) {
            try {
                ClasseDAO dao = new ClasseDAO();
                leituras = dao.listaLeituraPorColeta(coleta);
            } catch (Exception ex) {
                leituras = new ArrayList<>();
                Logger.getLogger(ListaLeituras.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("leituras",leituras);
            request.getRequestDispatcher("/WEB-INF/lista-leituras.jsp").forward(request, response);
        } else {
            try {
                ClasseDAO dao = new ClasseDAO();
                System.out.println(local);
                leituras = dao.listaLeituraPorLocal(local);
            } catch (Exception ex) {
                leituras = new ArrayList<>();
                Logger.getLogger(ListaLeituras.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("leituras",leituras);
            request.getRequestDispatcher("/WEB-INF/lista-leituras.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
