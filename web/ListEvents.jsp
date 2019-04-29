<%-- 
    Document   : ListEvents
    Created on : Apr 20, 2019, 6:11:33 PM
    Author     : LENOVO
--%>
<%@page import="tme.project.demo.model.Event"%>
<%@page import="tme.project.demo.model.User"%>
<%@page import="tme.project.demo.model.Location"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
        <link rel="stylesheet" href="css\ListAllEvent.css">
        <title> List All Events</title>
    </head>
    <body background="images\bg1.jpg" align="center">
        <div class="logout">


            <div class="out">
                <img src="images\logout .png" alt="">
                <label>Log out</label> 
            </div> 

            <%
                Event e = (Event) request.getAttribute("events");
                User u = User.getStudent(e.getStdId());

            %>
            <div class="OfficerID">
                <h6><%=session.getAttribute("Officer_ID")%></h6>
            </div>

        </div>

        <div class="header">
            <h2>Notification Event</h2> 
        </div>

        <div class="event">
            <div class="eventarea">
                <div class="notify">
                    <img src="images\alarm.png" alt="">
                    <h6>Notify</h6>
                </div>

                <div class="timedate">
                    <h6>02/03/2019 </h6>
                    <h6>15.00 p.m.</h6>
                </div>

                <div class="emergency">
                    <h6>Emergency :  </h6>
                </div>

                <div class="information"></div>
                <button>Accept</button>
            </div>
        </div>

        <div class="menubar">
            <img src="images\first-aid-kit.png" alt="">
            <img src="images\checklist (3).png" alt="">
            <img src="images\alarm (1).png" alt="">
            <img src="images\profile.png" alt="">
        </div>


    </div>
    <!-- Bootstrap core JavaScript
================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/dataTables.bootstrap.min.js"></script>

    <script type="text/javascript" class="init">
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
</body>
</html>
