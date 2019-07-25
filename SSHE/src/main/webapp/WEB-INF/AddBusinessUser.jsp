<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
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
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script >
$(document).ready(function(){
    $("#country").change(function(){
        var value = $(this).val();
        $.get("getoperator",{country:value},function(data){
         $("#operator").html(data);
        });}
    );
});
function getCircle(country)
{
	
	}

</script>
</head>
<body>
<form action="addCp" method="POST">
    <table class="col-md-5 mx-auto" id="cpusertable" cellpadding='15px' cellspacing='10px' >
        <tbody id="addbusertb" align="center">
           <tr>
           	<td>Country</td>
           	<td>
           		<select id="country">
           		<option value="0">Select Country</option>
           		
           	    <c:forEach items="${clist}" var="c">
           	    <option value="${c.getCountry()}">${c.getCountry()}</option>  
           	    </c:forEach>
           		</select>
           	</td>
           	</tr>
           	<br>
           <tr>
           <td>Operator</td>
           	<td>
           		<select id="operator">
           		<option value="0">Select Operator</option>
           		
           	    <c:forEach items="${olist}" var="o">
           	    <option value="${o.getOperator()}">${c.getOperator()}</option>  
           	    </c:forEach>
           		</select>
           	</td>
           </tr><br>
           <tr><td>Circle</td><td><input type="text" required name="circlename"></td></tr><br>
           <tr><td>CP ID</td><td><input type="text" required name="cpid"></td></tr><br>
           <tr><td>CP Name</td><td><input type="text" required name="cpname"></td></tr><br>
           <tr><td>CP Status</td><td><input type="radio" required name="cpstatus"value="1" > Active     
                    <input type="radio" required name="cpstatus" value="0"> Deactive</td></tr><br>
           <tr><td>IP List</td><td><input type="text" required name="iplist"></td></tr><br>
           <tr><td colspan="2"><button type="button" class="btn btn-danger">ADD</button></td></tr>
        </tbody>
        </table>

                                                            
</form>									
</body>
</html>

