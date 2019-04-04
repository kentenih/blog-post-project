/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import data.Comment;
import factory.CommentFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/* JSON-simple Library */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Ian
 */
public class Read {
    public static final String JSONFILEPATH = "C:\\Users\\Ian\\Documents\\NetBeansProjects\\PersonalBlogv2\\commentData.json";
    
    public static ArrayList readJson() {
        JSONObject jsonObject;
        JSONArray commentList;
        ArrayList<Comment> comments = new ArrayList();
        JSONParser jsonParser = new JSONParser();
        
        if (new File(JSONFILEPATH).exists()) {
            
            try (FileReader reader = new FileReader(JSONFILEPATH)) {
                Object obj = jsonParser.parse(reader);
                
                jsonObject = (JSONObject) obj;
                
                commentList = (JSONArray) jsonObject.get("comments");
                
                commentList.forEach((commentObject -> {
                    JSONObject commentData = (JSONObject) commentObject;
                    comments.add(CommentFactory.parseJson(commentData));
                }));
                
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
        
        return comments;
    }
}
