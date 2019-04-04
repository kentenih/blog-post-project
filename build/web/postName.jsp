<%-- 
    Document   : index
    Created on : Mar 4, 2019, 3:34:22 PM
    Author     : Ian
--%>

<%@page import="io.Output"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/personalBlog.css">
        <title>Personal Blog</title>
        <script>
            var replyButtons;
            
            window.addEventListener("load", setReplyButtons);
            
            function setReplyButtons() {
                replyButtons = document.getElementsByClassName("replyButton");
                
                Array.prototype.forEach.call(replyButtons, button => {
                    button.addEventListener("click", showReplyForm);
                })
            }
            
            function showReplyForm() {
                var commentNumber = this.parentNode.id.substring("comment".length, this.parentNode.id.length);
                var replyForm =  document.getElementById("replyForm" + commentNumber);
                
                if (replyForm.classList.contains("hide")) {
                    this.innerHTML = "Cancel";
                    replyForm.classList.remove("hide");
                } else {
                    this.innerHTML = "Reply";
                    replyForm.classList.add("hide");
                }
            }
        </script>
    </head>
    <body>
        <header>
            <h1><u>Buffer Overflow</u></h1>
        </header>
        <div class="container">
            <h2>Why I Collect Records in the Digital Age</h2>
            <hr> 
            <div class="authSocial">
                <table>
                    <tr>
                        <td><a href="https://www.linkedin.com/in/ian-kenten-5b8172154/" target="_blank" rel="author external"><img src="./images/LinkedIn.png" alt="LinkedIn"></a></td>
                        <td><a href="https://github.com/kentenih" target="_blank" rel="author external"><img src="./images/Github.png" alt="Github"></a></td>
                        <td><a href="mailto:kentenih@dukes.jmu.edu" rel="author"><img src="./images/Email.png" alt="Email"></a></td>
                    </tr>
                </table>
            </div>
            <div style='width:50%;'>
                <div style='margin-left:auto; margin-right:auto;width:350px;'>
                    <img src="./images/hitumwiththefingerguns.jpg" alt="Ian Kenten" class="authImage">
                    <p>
                        <strong>Ian Kenten</strong><br>
                        James Madison University<br>
                        Computer Science Student<br>
                        Mar 6, 2019 9:00:00 AM EST
                    </p>
                </div>
            </div>
            <div class="content">
            <hr>
            
                <img src="./images/StardewValleyRecords.jpg" alt="Stardew Valley Records" style="float:right; width: 40%;">
                <p>
                    The short answer is that I enjoy music and I think that they look 
                    cool. If you want the longer answer, continue reading. 
                    For most of my life I have had an appreciation of owning physical 
                    copies of different media over digital. I would say that it all 
                    started with my love of video games. When I was younger, digital 
                    distribution had not yet become the most common way of distributing 
                    video game releases so I grew up purchasing physical copies of 
                    different computer and console games. Often there were collectors 
                    editions with exclusive items for games that I would beg for or 
                    purchase myself. 
                </p>
                <p>
                    This concept of a "collectors edition" carried over to music 
                    when I eventually discovered my parents record collection and
                    that modern artists had limited vinyl releases that looked amazing.
                    The packaging often includes posters and art on the gatefold 
                    that is unique to the record release. Not to mention the records
                    themselves come in a variety of colors and patterns that are 
                    satisfying to look at as they spin on the turntable. Some records
                    even include easter eggs that aren't included in other releases.
                    It is also reassuring to have something that is tangible as it further 
                    establishes my ownership and in a world that has mostly gone digital.
                    What are your thoughts on records and what do you like to collect?
                </p>
            </div>
            <hr>
            <h3>Submit Comments</h3>
            <form action="postName" method="POST">
                <label for="user">Username:</label>
                <input type="text" id="commentUser" name="commentUser" required>
                <br><br>
                <textarea id="comment" name="comment" placeholder="Write a comment..." rows="4" cols="50" required></textarea>
                <br>
                <input type="submit" value="Submit Comment">
            </form>
            <hr>
            <% out.print(Output.outputCommentData()); %>
        </div>
    </body>
</html>
