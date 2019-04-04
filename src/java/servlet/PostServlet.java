/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

/* Java IO Library */
import io.Write;
import java.io.*;

/* JAVAX Servlet Library*/
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * Why I chose JSON: Without having access to a database, JSON made the most sense
 * to store data locally in an organized manner. I also have a decent amount of 
 * experience with JSON so I am familiar with how to write/read it. Finding a 
 * library that can write/read JSON files was also straightforward as I found
 * the JSON-simple library rather...simply. It also helped to inform my design
 * because of how it organized it was.
 * 
 * @author Ian
 */
@WebServlet("/postName")
public class PostServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String path = "/postName.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request,response);
    }
    
    /**
     * When a form's action is "comment" and method is "POST", this method will
     * be called. First the method checks to see if the commentData.json file
     * exists. If it does, it will retrieve the necessary JSON information from
     * the .json file. If it does not, it will create a new JSONObject and JSONArray
     * to store the necessary information. The information put into the comment 
     * form will be saved into commentData.json. The information included is a user,
     * comment, date/time, and commentNumber. This is accomplished by calling the
     * writeCommentData() method.
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        if (request.getParameter("comment") != null) {
            Write.jsonComment(request);
        } else if (request.getParameter("reply") != null) {
            Write.jsonReply(request);
        }
        
       response.sendRedirect(request.getContextPath() + "/postName"); // Prevents being directed to a blank /postName after the POST
    }
}

