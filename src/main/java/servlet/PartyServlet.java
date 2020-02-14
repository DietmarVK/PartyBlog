package servlet;

import bl.PartyBlogModel;
import data.PartyBlogEntry;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HEILJulian
 */
@WebServlet(name = "PartyServlet", urlPatterns = {"/PartyServlet"})
public class PartyServlet extends HttpServlet {

    private PartyBlogModel model = PartyBlogModel.getInstance();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            request.getRequestDispatcher("partyForm.html").include(request, response);
            for (PartyBlogEntry entry : model.getAllEntries()) {
                out.println(entry.toString());
                out.print("<br>");
            }
            out.println("<hr>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(PartyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Einlesen & Prüfen Parameter
            String nickname = request.getParameter("nickname");
            String eMail = request.getParameter("eMail");
            String comment = request.getParameter("comment");
            int rate = Integer.parseInt(request.getParameter("rate"));
            
            //||..ODER mit Short Curcuit Evaluation
            if (nickname == null || eMail == null || comment == null) {
                System.out.println("Error bitte alle Eingaben ausfüllen!");
                return;
            }
            PartyBlogEntry entry = new PartyBlogEntry(nickname, eMail, comment, rate);
            model.addEntry(entry);
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PartyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
