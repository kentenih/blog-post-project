/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Ian
 */
public class Write {
   
    public static void jsonComment(HttpServletRequest request) {
        JSONArray commentList;
        JSONObject jsonObject;
        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader(Read.JSONFILEPATH)) {
            Object obj = jsonParser.parse(reader);

            jsonObject = (JSONObject) obj;
            commentList = (JSONArray) jsonObject.get("comments");
                
            writeCommentJson(request, jsonObject, commentList);
            
            reader.close();
        } catch (IOException ioe) {
            jsonObject = new JSONObject();
            commentList = new JSONArray();
            
            writeCommentJson(request, jsonObject, commentList);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }


    private static void writeCommentJson(HttpServletRequest request, JSONObject jsonObject, JSONArray commentList) {
        JSONObject commentDetails = new JSONObject();
        JSONArray replyList = new JSONArray();
        String user = request.getParameter("commentUser");
        String comment= request.getParameter("comment");
        String commentDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        
        commentDetails.put("user", user);
        commentDetails.put("text", comment);
        commentDetails.put("dateTime", commentDateTime);
        commentDetails.put("number", commentList.size());
        
        commentDetails.put("replies", replyList);
            
        commentList.add(commentDetails); // Adding Comment Object to Comments Array
        
        jsonObject.put("comments", commentList); // Adding Comments Array to jsonObject
            
        try (FileWriter file = new FileWriter(Read.JSONFILEPATH)) {             
            file.write(jsonObject.toJSONString());
            file.flush();
            file.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public static void jsonReply(HttpServletRequest request) {
        JSONArray commentList;
        JSONArray replyList;
        JSONObject jsonObject;
        JSONObject commentDetails;
        JSONObject replyDetails;  
        JSONParser jsonParser = new JSONParser();
        String user = request.getParameter("replyUser");
        String comment= request.getParameter("reply");
        int parentCommentNumber = Integer.parseInt(request.getParameter("replyNumber")); // The number of the comment that the user replied to
        String replyDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        
        try (FileReader reader = new FileReader(Read.JSONFILEPATH)) {
            Object obj = jsonParser.parse(reader);
            
            jsonObject = (JSONObject) obj;
            commentList = (JSONArray) jsonObject.get("comments");
            commentDetails = (JSONObject) commentList.get(parentCommentNumber); // Get the Comment Details of the comment the user replied to
            replyList = (JSONArray) commentDetails.get("replies");
            
            reader.close();
            
            replyDetails = new JSONObject(); // Reply Object
        
            replyDetails.put("user", user);
            replyDetails.put("text", comment);
            replyDetails.put("dateTime", replyDateTime);
            replyDetails.put("number", replyList.size());

            replyList.add(replyDetails); // Adding Reply Object to Reply List (Array)

            commentDetails.put("replies", replyList); // Adding Reply List (Array) to the Comment Details
            
            commentList.set(parentCommentNumber, commentDetails); // Changing the Comment Details of the comment the user replied to based on the parentCommentNumber
            
            jsonObject.put("comments", commentList); // Adding Comments List (Array) to jsonObject
            
            FileWriter file = new FileWriter(Read.JSONFILEPATH); // Write to commentData.json file       
            file.write(jsonObject.toJSONString());
            file.flush();
            file.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }
}

