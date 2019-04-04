/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Ian
 */
public class Reply {
    private final String user;
    private final String reply;
    private final String replyTime;
    private final Long replyNumber;
    
    public Reply (String user, String reply, String replyTime, Long replyNumber) {
        this.user = user;
        this.reply = reply;
        this.replyTime = replyTime;
        this.replyNumber = replyNumber;
    }
    
    public String getUser() {
        return user;
    }
    
    public String getReply() {
        return reply;   
    }
    
    public String getReplyTime() {
        return replyTime;
    }
    
    public Long getReplyNumber() {
        return replyNumber;
    }
}
