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
    
    /**
     * When a user goes to localhost:8080/PersonalBlogv2/postName in a browser,
     * executing a "GET" request to /postName, the postName.jsp file will be
     * served up to hte user.
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String path = "/postName.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request,response);
    }
    
    /**
     * When a HTML form in the postName.jsp file has the action "POST", this 
     * method will be executed. If the request has the "comment" parameter, the
     * Write.jsonComment() method will be called to write the comment information
     * to commentData.json. If the request has the "reply" parameter, the 
     * Write.jsonComment() method will be called to write the reply information
     * to commentData.json.
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

