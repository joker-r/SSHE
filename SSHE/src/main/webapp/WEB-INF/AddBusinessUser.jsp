<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/admin.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body >
<form action="addcpuser" method="POST">
    <table class="col-md-5 mx-auto" id="cpusertable" cellpadding='15px' cellspacing='10px' >
        <tbody id="addbusertb" align="center">
           <tr><td>Country</td><td><input type="text" required name="countryname"></td></tr><br>
           <tr><td>Operator</td><td><input type="text" required name="operatorname"></td></tr><br>
           <tr><td>Circle</td><td><input type="text" required name="circlename"></td></tr><br>
           <tr><td>CP ID</td><td><input type="text" required name="cpid"></td></tr><br>
           <tr><td>CP Name</td><td><input type="text" required name="cpname"></td></tr><br>
           <tr><td>CP Status</td><td><input type="radio" required name="cpstatus"value="active" > Active     
                    <input type="radio" required name="cpstatus" value="deactive"> Deactive</td></tr><br>
           <tr><td>IP List</td><td><input type="text" required name="iplist"></td></tr><br>
           <tr><td colspan="2"><button type="button" class="btn btn-danger">ADD</button></td></tr>
        </tbody>
        </table>

                                                            
</form>									
</body>
</html>