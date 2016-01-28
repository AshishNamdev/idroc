/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comms.CommStrings;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author anamdev
 */
public class Signup extends HttpServlet
{

    private User user = null;
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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher(CommStrings.homePage);
        PrintWriter out = response.getWriter();
        if (this.isRegisteredUser(request))
        {
           out.println("<span id='cResponse'>This user is already registered</span>");
           dispatcher.include(request, response);
        }
        this.initializParams(request);
        if (user.addUSer())
        {
           out.println("<span id='sResponse'>Succefully Registered</span>");
           out.println("<span id = 'lDirection'><a href = '"+CommStrings.homePage+"'> Click here </a> to Login</span>");
           dispatcher.include(request, response);
        }
    }
    
    public void initializParams(HttpServletRequest request)
    {
        String email = request.getParameter(CommStrings.emailParam);
        String password = request.getParameter(CommStrings.passwordParam);
        String fName = request.getParameter(CommStrings.fNameParam);
        String mName = request.getParameter(CommStrings.mNameParam);
        String lName = request.getParameter(CommStrings.lNameParam);
        
        user = new User();
        
        user.setEmail(email);
        user.setPassword(password);
        user.setfName(fName);
        user.setmName(mName);
        user.setlName(lName);
    }
    
    public boolean isRegisteredUser(HttpServletRequest request)
    {
        boolean ret = false;
        String email = request.getParameter(CommStrings.emailParam);
        User usr = new User();
        user.setEmail(email);
        if (usr.checkUser())
            ret = true;
        return ret;
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
