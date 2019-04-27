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
    <body background="images\bg1.jpg"> 
        <div class="logout">
            <div class="container">

                <div class="out">
                    <img src="images\logout .png" alt="">
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
                    <img src="images\addpic.png" alt="">

                </div>
                <textarea name="comment" id="" cols="30" rows="4" placeholder="Specify information.."></textarea>

                <div class="attachvoice">
                    <img src="images\addvoice.png" alt="">
                </div>

                <div class="specifyphonenumber">
                    <input type="number" placeholder="Phone number">
                </div>
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
