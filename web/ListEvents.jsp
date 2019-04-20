<%-- 
    Document   : ListEvents
    Created on : Apr 20, 2019, 6:11:33 PM
    Author     : LENOVO
--%>
<%@page import="tme.project.demo.model.Event"%>
<%@page import="tme.project.demo.model.Location"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>TME - Event List</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sticky-footer-navbar.css" rel="stylesheet">

        <link href="css/dataTables.bootstrap.min.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <title>TME - Event List</title>
        <style>
            html,body{
                background-color:#F5F5F5;
                color: #000000;
            }
            .page-header{
                background-color:#FFFFFF;
                padding-top: 40px ;
                padding-left: 30px;
                padding-right: 30px;
                padding-bottom: 40px;
                color: #000000;
                font-family:Cordia New;
                text-align:center;
            }
            .container{
                width:1000px;
            }
            .block1{
                float:right;
            }
            .now{
                float:right;
            }
        </style>
    </head>
    <body>

        <!-- Fixed navbar -->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="block2">
                        <a class="navbar-brand" href="ListEvents">TME |</a>
                        <div class="block1">
                            <div id="navbar" class="collapse navbar-collapse">
                                <ul class="nav navbar-nav">
                                    <li><a href="Home"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home</a></li>
                                    <li><a href="AddTicket"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Ticket</a></li> 
                                    <li class="active"><a href="ListTickets"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> List all ticket</a></li>
                                    <li><a href="MyTickets"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> My Tickets</a></li>
                                    <li><a href="Logout"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Log out</a></li>
                                </ul>
                            </div>
                        </div><!--/.nav-collapse -->
                    </div>
                </div>
                <div class="now">
                    <a class="navbar-brand"><font size="3"><font color="#9ACD32"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></font>
                        <%=session.getAttribute("user_name")%> Login Now</font></a>
                </div>
            </div>
        </nav>

        <!-- Begin page content -->
        <div class="container">
            <div class="page-header">
                <h1><font size="600">╔ <b><u>LIST ALL EVENTS</u></b> ╝</font>
                    </br><font size=50> TME </font></h1>
            </div>

            <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Description</th>
                        <th>Location</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                     
                    %>

                </tbody>
            </table>
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
