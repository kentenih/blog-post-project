/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 * A Comment class designed to store comment information. That information
 * can be accessed with get methods after a Comment object is made and the 
 * values are initialized with the constructor.
 * 
 * @author Ian Kenten
 */
public class Comment {
    private ArrayList<Reply> replyList;
    private final String user;
    private final String comment;
    private final String commentTime;
    private final Long commentNumber;
    
    public Comment (String user, String comment, String commentTime, 
            Long commentNumber, ArrayList<Reply> replyList) {
        this.user = user;
        this.comment = comment;
        this.commentTime = commentTime;
        this.commentNumber = commentNumber;
        this.replyList = replyList;
    }
    
    public ArrayList<Reply> getReplies() {
        return replyList;
    }
    
    public String getUser() {
        return user;
    }
    
    public String getComment() {
        return comment;
    }
    
    public String getCommentTime() {
        return commentTime;
    }
    
    public Long getCommentNumber() {
        return commentNumber;
    }
}
