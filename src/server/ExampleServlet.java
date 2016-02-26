package server;

import ejb.GruppaService;
import ejb.PersonService;
import tables.Gruppa;
import tables.Person;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yevhen on 26.02.2016.
 */
@WebServlet(name = "ExampleServlet", urlPatterns = {"/main"})
public class ExampleServlet extends HttpServlet {
    @EJB
    PersonService ps;
    @EJB
    GruppaService gs;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gruppa_name = request.getParameter("gruppa_name");
        gs.create(gruppa_name);
        response.sendRedirect("main");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("grupps", gs.findAll());
        request.getRequestDispatcher("/grupps.jsp").forward(request,response);
    }
}
