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
import model.Inventory;

/**
 *
 * @author anamdev
 */
public class InventoryServ extends HttpServlet
{
    Inventory inventory;
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
        PrintWriter out = response.getWriter();
        inventory = new Inventory();
        inventory.setInvId(request.getParameter(CommStrings.INVID));
        RequestDispatcher dispatcher = request.getRequestDispatcher(CommStrings.INVENTORYPAGE);
        
        if(inventory.isAlreadyAdded())
        {
            out.println("<span id='iResponse'> Inventory is already present , Please check your inventory id</span>");
            dispatcher.include(request, response);
        }
        else
        {
            this.initializParams(request);
            if (inventory.addInventory())
            {
                out.println("<span id='sResponse'>Succefully added <a href = '"+CommStrings.HOMEPAGE+"'> "+inventory.getInvId()+" in system</a></span>");
                dispatcher.include(request, response);
            }
        }
    }

    public void initializParams(HttpServletRequest request)
    {
        inventory.setInvName(request.getParameter(CommStrings.INVNAME));
        inventory.setInvDetail(request.getParameter(CommStrings.INVDETAIL));
        inventory.setInvType(request.getParameter(CommStrings.INVTYPE));
        inventory.setInvLocation(request.getParameter(CommStrings.INVLOCATION));
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
