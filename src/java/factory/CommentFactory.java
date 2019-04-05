/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import data.Comment;
import data.Reply;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Creates Comment objects. Having a factory class for Comments enables 
 * the code to be more flexible if I wanted to use another method to store 
 * comment information such as a relational or non-relational database.
 * If I needed to parse information from a query, I would just need to 
 * create a new method such as parseDatabaseQuery().
 * 
 * @author Ian
 */
public class CommentFactory {
    
    /**
     * Retrieves comment information from a passed JSONObject and
     * creates new Comment objects accordingly.
     * 
     * @param commentData
     * @return Comment object
     */
    public static Comment parseJson(JSONObject commentData) {
        String user = (String) commentData.get("user");
        String comment = (String) commentData.get("text");
        String commentTime = (String) commentData.get("dateTime");
        Long commentNumber = (Long) commentData.get("number");
        JSONArray jsonReplies = (JSONArray) commentData.get("replies");
        ArrayList<Reply> replyList = new ArrayList();
        
        jsonReplies.forEach(replyObject -> {
            JSONObject replyData = (JSONObject) replyObject;
            replyList.add(ReplyFactory.parseJson(replyData));
        });
        
        return new Comment (user, comment, commentTime, commentNumber, replyList);
    }
    
}
