<%-- 
    Document   : NotifiyToOfficer
    Created on : Apr 17, 2019, 2:16:15 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Emergency Notify</title>

    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link rel="stylesheet" href="css\Notify.css">
    <body background="images\bg1.jpg" align="center"> 
        <div class="logout">
            
            <div class="container">
                <div class="out">
                    <img src="images\logout .png" alt="">
                    <label><a href="Logout"> Log out</a></label> 

                </div> 

                <div class="studentID">
                    ${sessionScope.student_id}

                </div>

            </div>
        </div>

        <div class="header">
            <h2>Emergency Notify</h2> 
        </div>

        <div class="map">

        </div>
        <%
            if (request.getAttribute("code") != null) {
        %>
        <div class="alert alert-<%=(String) request.getAttribute("code")%>">
            <strong><%=(String) request.getAttribute("alert")%></strong> 
            <%=(String) request.getAttribute("message")%>
        </div>
        <%
            }
        %>

        <div class="specifyInformation">
            <div class="container">
                <form action="AddEvent" method="post">
                    <div class="attachPicture">
                        <img src="images\addpic.png" alt="">

                    </div>
                    <textarea name="comment" id="" cols="30" rows="4" placeholder="Specify information.."></textarea>

                    <div class="attachvoice">
                        <img src="images\addvoice.png" alt="">
                    </div>

                    <div class="specifyphonenumber">
                        <input type="number" placeholder="Phone number"><br>
                    </div>
                    <br>
                </form>
                <input name="student_id" type="hidden" value="<%=session.getAttribute("Student_ID")%>">
                <button type="submit" name="submit" > SUBMIT </button>       
            </div>            
        </div>

        <div class="menubar">

            <img src="images\first-aid-kit.png" alt="">
            <img src="images\checklist (3).png" alt="">
            <img src="images\alarm (1).png" alt="">
            <img src="images\profile.png" alt="">
        </div>

    </body>
</html>