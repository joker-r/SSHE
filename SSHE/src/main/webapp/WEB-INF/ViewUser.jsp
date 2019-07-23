<html>
<head>
<link href="css/admin.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
  
<h4 class="text-center" style="font-family: 'lato',sans-serif; font-weight: bold">Users List</h4>

<table class="table  table-sm table-bordered table-striped table-hover col-md-4 mx-auto">
  <tr>
    <th bgcolor="#e41937" style="font-family: 'lato',sans-serif; font-weight: bold; color: white">User Name</th>
    <th bgcolor="#e41937" style="font-family: 'lato',sans-serif; font-weight: bold; color: white">User Type</th>
  </tr>
  
  <c:forEach items="${ulist}" var="u">
  <tr>
  <td>${u.username}</td>
  <td>${u.usertype}</td>  
  </tr>
  </c:forEach>
  
</table>
</body>
</html>
