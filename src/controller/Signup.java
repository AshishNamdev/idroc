/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comms.CommStrings;
import comms.GenerateUID;
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
        RequestDispatcher dispatcher = request.getRequestDispatcher(CommStrings.HOMEPAGE);
        PrintWriter out = response.getWriter();
        user = new User();
        System.out.println("in Singup.java");
        user.setEmail(request.getParameter(CommStrings.EMAIL));

        // check if User already registered
        if (user.loginUser(false))
        {
           out.println("<span id='sResponse'>This user is already registered</span>");
           dispatcher.include(request, response);
        }
        else
        {
            this.initializParams(request);
            if (user.addUSer())
            {
                out.println("<span id='sResponse'>Succefully Registered");
                out.println("<a href = '"+CommStrings.HOMEPAGE+"'> Click here </a> to Login</span>");
                dispatcher.include(request, response);
            }
        }
        out.close();
    }
    
    public void initializParams(HttpServletRequest request)
    {
        String email = request.getParameter(CommStrings.EMAIL);
        user.setUid(GenerateUID.UID(email));
        user.setEmail(email);
        user.setPassword(request.getParameter(CommStrings.PASSWORD));
        user.setfName(request.getParameter(CommStrings.FNAME));
        user.setmName(request.getParameter(CommStrings.FNAME));
        user.setlName(request.getParameter(CommStrings.LNAME));
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
