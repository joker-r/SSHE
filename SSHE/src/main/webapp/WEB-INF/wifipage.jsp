<link href="css/admin.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body >
<form action="otpgenerate" method="POST">
<div class="adduserdetails">
    <table id="addusertable" class="col-md-5 mx-auto" cellpadding='20px' cellspacing='10px' >
        <tbody style="display: flex;flex-direction: column;align-items: center;">
            <tr>
                <td>${countrycode}</td>
                 <td>${opcoId}</td>
                <td><input type="text" required name="username"></td>
            </tr>
            
            
            <tr>
                <td><input type="submit" class="btn btn-danger"/></td>
            </tr>
        </tbody>
    </table>
</div>                                                    
</form>									
</body>
</html>