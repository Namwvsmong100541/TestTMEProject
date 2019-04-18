<%-- 
    Document   : Login
    Created on : Apr 17, 2019, 2:07:03 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Tell Me Emergency</title>

        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
        <link rel="stylesheet" href="Login.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body background="TestProjecttME\web\img-TME\bg1.jpg">
        <div class="login">
            <div class="container">
                <div class="logo">
                    <img src="TestProjectTME\web\img-TME\alarm.png" alt="">

                    <%
                        if (request.getAttribute("code") != null) {
                    %>
                    <div class="alert alert-success alert-<%=(String) request.getAttribute("code")%>">
                        <strong>
                            <font color="#000000"><%=(String) request.getAttribute("alert")%>
                        </strong> <%=(String) request.getAttribute("message")%>
                        </font>
                    </div>
                    <%
                        }
                    %> 

                    <form>
                        <input type="text" placeholder="&nbsp;&nbsp;Student ID"><br>
                        <input type="text" placeholder="&nbsp;&nbsp;Password"><br>
                        <label>Forget password ?</label><br>
                        <button>Log In</button>

                </div>
            </div>
        </div>



    </body>

</html>
