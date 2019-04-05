/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import data.Reply;

import org.json.simple.JSONObject;

/**
 * Creates Reply objects. Having a factory class for Reply enables 
 * the code to be more flexible if I wanted to use another method to store 
 * reply information such as a relational or non-relational database.
 * If I needed to parse information from a query, I would just need to 
 * create a new method such as parseDatabaseQuery().
 * 
 * @author Ian
 */
public class ReplyFactory {
    
    /**
     * Retrieves comment information from a passed JSONObject and
     * creates new Comment objects accordingly.
     * 
     * @param replyData
     * @return Reply object
     */
    public static Reply parseJson(JSONObject replyData) {
        String user = (String) replyData.get("user");
        String reply = (String) replyData.get("text");
        String replyTime = (String) replyData.get("dateTime");
        Long replyNumber = (Long) replyData.get("number");
        
        return new Reply(user, reply, replyTime, replyNumber);
    }
    
}
