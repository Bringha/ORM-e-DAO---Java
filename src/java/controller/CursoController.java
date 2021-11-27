/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.CursoDAO;

/**
 *
 * @author fabio
 */
public class CursoController extends HttpServlet {

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

        String msg;
        String tip = request.getParameter("tip");

        if (tip.equalsIgnoreCase("insert")) {
            try {
                //pegar os dados
                String nom = request.getParameter("nom");
                String des = request.getParameter("des");
                String val = request.getParameter("val");
                //criar o objeto Curso
                Curso obj = new Curso();
                //ajustar usando os SETs
                obj.setNome(nom);
                obj.setDescricao(des);
                obj.setValor(Double.parseDouble(val));
                //criar o objeto DAO
                CursoDAO dao = new CursoDAO();
                //usar o método de inserçao =>S dao.inserir(obj)
                int res = dao.inserir(obj);
                if (res > 0) {
                    msg = "ok";
                } else {
                    msg = "bugInsert";
                }
            } catch (NumberFormatException e) {
                msg = "bugException";
            }

        } else if (tip.equalsIgnoreCase("update")) {
            try {
                //pegar os dados
                String cod = request.getParameter("cod");
                String nom = request.getParameter("nom");
                String des = request.getParameter("des");
                String val = request.getParameter("val");
                //criar o objeto Curso
                Curso obj = new Curso();
                //ajustar usando os SETs
                obj.setCodigo(Long.parseLong(cod));
                obj.setNome(nom);
                obj.setDescricao(des);
                obj.setValor(Double.parseDouble(val));
                //criar o objeto DAO
                CursoDAO dao = new CursoDAO();
                //usar o método de atualizaçao =>S dao.atualizar(obj)
                int res = dao.atualizar(obj);
                if (res > 0) {
                    msg = "ok";
                } else {
                    msg = "bugUpdate";
                }
            } catch (NumberFormatException e) {
                msg = "bugException";
            }
        } 

        response.sendRedirect("index.jsp?msg=ok");
    }

    /**
     * método exclusivo para deletar um registro, enviando "tip" e código por GET
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String msg = "";
        String tip = request.getParameter("tip");

        if (tip.equalsIgnoreCase("delete")) {
            try {
                //pegar o código enviado
                String cod = request.getParameter("cod");
                //criar o objeto Curso
                Curso obj = new Curso();
                //ajustar usando os SETs
                obj.setCodigo(Long.parseLong(cod));
                //criar o objeto DAO
                CursoDAO dao = new CursoDAO();
                //usar o método de exclusao =>S dao.excluir(obj)
                int res = dao.excluir(obj);
                if (res > 0) {
                    msg = "ok";
                } else {
                    msg = "bugDelete";
                }
            } catch (NumberFormatException e) {
                msg = "bugException";
            }            
        }
        response.sendRedirect("index.jsp?msg=ok");
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
        processDelete(request, response);
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
        processRequest(request, response);
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
