/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import data.Comment;
import data.Reply;

import java.util.ArrayList;

/**
 *
 * @author Ian
 */
public class Output {
    
    public static String outputCommentData () {
        ArrayList<Comment> commentData = Read.readJson();
        StringBuilder comments = new StringBuilder();
        
        comments.append(getCommentHeader(commentData.size()));
        
        for (Comment comment : commentData) {
            comments.append(getCommentFormat(comment));
            
            comments.append(getReplyHeader(comment.getReplies().size()));
            comments.append("<div class=\"replies\">\n");
            
            for (Reply reply : comment.getReplies()) {
                comments.append(getReplyFormat(reply, comment.getCommentNumber()));
            }
            
            comments.append("</div>\n");
            
            comments.append("</div>\n");
        }
        
        comments.append("</div>\n");
        
        return comments.toString();
    }
    
    private static String getCommentHeader(int numberOfComments) {
        return "<h3>Comments (" + numberOfComments + ")</h3>\n<div class=\"comments\">\n";
    }
    
    private static String getCommentFormat(Comment comment) {
        return "<div id=\"comment" + comment.getCommentNumber() + "\" class=\"comment\">\n" 
            + "<p><span class=\"username\">" + comment.getUser() + "</span> | " + comment.getCommentTime() + " EST</p>\n"
            + "<p>" + comment.getComment() + "</p>\n"
            + "<button class=\"replyButton\">Reply</button><br>\n" + getReplyForm(comment.getCommentNumber()) + "\n";
    }
    
    private static String getReplyForm(Long commentNumber) {
       return "<form id=\"replyForm" + commentNumber + "\" action=\"postName\" method=\"POST\" class=\"hide\">\n"
            + "<hr><label for=\"user\">Username:</label>\n"
            + "<input type=\"text\" id=\"replyUser" + commentNumber + "\" name=\"replyUser\" target=\"_blank\" required>\n"
            + "<br><br>\n"
            + "<textarea id=\"reply" + commentNumber + "\" name=\"reply\" placeholder=\"Write a reply...\"rows=\"4\" cols=\"50\" required></textarea>\n"
            + "<input type=\"number\" id=\"replyNumber" + commentNumber + "\" name=\"replyNumber\" value=\"" + commentNumber + "\" hidden>"
            + "<br>\n"
            + "<input type=\"submit\" value=\"Submit Reply\">\n"
            + "</form>\n"; 
    }
    
    private static String getReplyHeader(int numberOfReplies) {
        return "<hr>\n<p>Replies (" + numberOfReplies + ")</p>\n";
    }
    
    private static String getReplyFormat(Reply reply, Long commentNumber) {
        return "<div id=\"reply" + commentNumber + "" + reply.getReplyNumber() + "\" class=\"reply\">\n" 
            + "<p><span class=\"username\">" + reply.getUser() + "</span> | " + reply.getReplyTime() + " EST</p>\n"
            + "<p>" + reply.getReply() + "</p></div>\n";
    }
}
