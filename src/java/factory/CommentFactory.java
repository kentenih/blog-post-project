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
 *
 * @author Ian
 */
public class CommentFactory {
    
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
