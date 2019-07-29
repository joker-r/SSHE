<html>
    <head>
    <link rel="icon" type="image/png" href="Photos/comviva.png">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        	<link href="format.css" rel="stylesheet">
        	<link href="css/admin.css" rel="stylesheet">
        <style>
            body{
                background-image:url("/Photos/contact.jpg");
                background-repeat: no-repeat;
                background-position: center;
                background-size: cover;
                }
        </style>
    </head>
<body >
    <div class="container2">
    <div class="subscription-window">
    <div><p>Please enter your One Time Password received by SMS.</p></div>
       <div id="subdetails"><form action="OTPValidate">
            <input id="otpfield" type="password" name="otp" placeholder="Enter the OTP"><br>
            <input id="resendotp" type="submit" class="btn btn-primary" value="RESEND" >
            <input id="subscribe" type="submit" class="btn btn-primary" value="SUBSCRIBE" >
          </form>
        </div>
    </div>    
    </div>   
</body>    
</html>
