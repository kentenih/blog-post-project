/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import data.Reply;

import org.json.simple.JSONObject;

/**
 *
 * @author Ian
 */
public class ReplyFactory {
    
    public static Reply parseJson(JSONObject replyData) {
        String user = (String) replyData.get("user");
        String reply = (String) replyData.get("text");
        String replyTime = (String) replyData.get("dateTime");
        Long replyNumber = (Long) replyData.get("number");
        
        return new Reply(user, reply, replyTime, replyNumber);
    }
    
}
