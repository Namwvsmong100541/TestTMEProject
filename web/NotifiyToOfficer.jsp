<%-- 
    Document   : NotifiyToOfficer
    Created on : Apr 17, 2019, 2:16:15 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Emergency Notify</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link rel="stylesheet" href="Notify.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
    <div class="logout">
        <div class="container">
           
            <div class="out">
            <img src="TestProjectTME\web\img-TME\logout .png" alt="">
            <label>Log out</label> 
           
        </div> 
        <div class="studentID"></div>
        
        </div>
    </div>

    <div class="header">
        <h2>Emergency Notify</h2> 
    </div>

    <div class="map">
        
    </div>
    
    <div class="specifyInformation">
        <div class="container">
            <div class="attachPicture">
                <img src="TestProjecttME\web\img-TME\addpic.png" alt="">
                
            </div>
            <textarea name="comment" id="" cols="30" rows="4" placeholder="Specify information.."></textarea>
            
            <div class="attachvoice">
                <img src="TestProjecttME\web\img-TME\addvoice.png" alt="">
            </div>

            <div class="specifyphonenumber">
                 <input type="number" placeholder="Phone number">
            </div>
    </div>
    </div>

    <div class="menubar">
        
        <img src="TestProjecttME\web\img-TME\first-aid-kit.png" alt="">
        <img src="TestProjecttME\web\img-TME\checklist (3).png" alt="">
        <img src="TestProjecttME\web\img-TME\alarm (1).png" alt="">
        <img src="TestProjecttME\web\img-TME\profile.png" alt="">
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
