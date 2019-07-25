<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="css/admin.css" rel="stylesheet">
    <link href="format.css" rel="stylesheet" >
    
<script >
function getOperator(country)
{
	 var URL = "getoperator?country="+country;
	 console.log(URL);
	 var xmlhrrp;

	 if (window.XMLHttpRequest) {

	 xmlhttp = new XMLHttpRequest();

	 } else {

	 xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

	 }

	 xmlhttp.onreadystatechange = function() {
	 if (this.readyState == 4 && this.status == 200) {
	       var data = xmlhttp.responseText;
	      
	 console.log("operator list"+data);
	 $('#operator').empty();
	 if(data==''){
	     console.log("No data for Operator.");
	 }else{
	 data=data.split(',');
	 console.log(data);
	 for(var i=0;i<data.length;i++){
	 $('#operator').append('<option value="'+data[i].trim()+'">'+data[i].trim()+'</option>');
	 console.log("list value"+data[i]);
	 }
	 }
	 if($('#country').val()!='select'){
	 $('#operator').append("<option value='select'>select</option>");
	 $('#operator').val('select');
	 } 

	 }
	 };

	 xmlhttp.open("GET", URL, true);

	 xmlhttp.send();

	        
	 }
	
function getCircle(operator)
{
	var country=document.getElementById("country").value;
	 var URL = "getcircle?country="+country+"&operator="+operator;
	 console.log(URL);
	 var xmlhrrp;

	 if (window.XMLHttpRequest) {

	 xmlhttp = new XMLHttpRequest();

	 } else {

	 xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

	 }

	 xmlhttp.onreadystatechange = function() {
	 if (this.readyState == 4 && this.status == 200) {
	       var data = xmlhttp.responseText;
	      
	 console.log("circle list"+data);
	 $('#circle').empty();
	 if(data==''){
	     console.log("No data for Circle.");
	 }else{
	 data=data.split(',');
	 console.log(data);
	 for(var i=0;i<data.length;i++){
	 $('#circle').append('<option value="'+data[i].trim()+'">'+data[i].trim()+'</option>');
	 console.log("list value"+data[i]);
	 }
	 }
	  if($('#operator').val()!='select'){
	 $('#circle').append("<option value='select'>select</option>");
	 $('#circle').val('select');
	 } 

	 }
	 };

	 xmlhttp.open("GET", URL, true);

	 xmlhttp.send();

	        
	 }
	 
function getCPID(circle)
{
	var country=document.getElementById("country").value;
	var operator=document.getElementById("operator").value;
	 var URL = "getcpid?country="+country+"&operator="+operator+"&circle="+circle;
	 console.log(URL);
	 var xmlhrrp;

	 if (window.XMLHttpRequest) {

	 xmlhttp = new XMLHttpRequest();

	 } else {

	 xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

	 }

	 xmlhttp.onreadystatechange = function() {
	 if (this.readyState == 4 && this.status == 200) {
	       var data = xmlhttp.responseText;
	      
	 console.log("cpid list"+data);
	 $('#cpid').empty();
	 if(data==''){
	     console.log("No data for CPID.");
	 }else{
	 /* data=data.split(','); */
	 console.log(data);
	 $('#cpid').append('<option value="'+data.trim()+'">'+data.trim()+'</option>');
	 console.log("list value"+data);
	 
	 }
	  if($('#circle').val()!='select'){
	 $('#cpid').append("<option value='select'>select</option>");
	 $('#cpid').val('select');
	 } 

	 }
	 };

	 xmlhttp.open("GET", URL, true);

	 xmlhttp.send();

	        
	 }
	

</script>
    
</head>
<body>
<form action="addProduct" method="POST">
    <table class="col-md-5 mx-auto" id="cpusertable" cellpadding='15px' cellspacing='10px' >
        <tbody id="addbusertb" align="center">
           
            <tr>
           	<td>Country</td>
           	<td>
           		<select id="country" onchange="getOperator(this.value)" name="txtcountry">
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
           		<select id="operator" onchange="getCircle(this.value)" name="txtoperator">
           		<option value="0">Select Operator</option>
           		</select>
           	</td>
           </tr><br>
           <tr>
           <td>Circle</td>
           	<td>
           		<select id="circle" name="txtcircle" onchange="getCPID(this.value)">
           		<option value="0">Select Circle</option>
           		</select>
           	</td>
           </tr><br>

           <tr><td>CP ID</td>
            <td>
           		<select id="cpid" name="txtcpid">
           		<option value="0">Select CP ID</option>
           		</select>
           	</td>
            </tr><br>
           <tr><td>Product ID</td>
            <td><input type="text" required name="txtproductid"></td>
            </tr><br>
           <tr><td>Product Name</td>
            <td><input type="text" required name="txtproductname"></td>
            </tr><br>
           <tr><td>Notify URL</td>
            <td><input type="text" required name="txturl"></td>
            </tr><br>
          
           <tr><td colspan="2"><input type="submit" class="btn btn-danger" value="ADD"></td></tr>
        </tbody>
        </table>

                                                            
</form>	


</body>
</html>