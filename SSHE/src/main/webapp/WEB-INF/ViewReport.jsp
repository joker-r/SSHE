<html lang="en">
<head>
  <title>View Report</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>

<body>

<h2 class="text-center" style="font-family: 'lato',sans-serif; font-weight: bold">Report</h2>

<table class="table  table-sm table-bordered table-striped table-hover col-md-4 mx-auto">
  <tr>
    <th bgcolor="#e41937" style="font-family: 'lato',sans-serif; font-weight: bold; color: white">CP Name</th>
    <th bgcolor="#e41937" style="font-family: 'lato',sans-serif; font-weight: bold; color: white">Service</th>
    <th bgcolor="#e41937" style="font-family: 'lato',sans-serif; font-weight: bold; color: white">Total Hits</th>
    <th bgcolor="#e41937" style="font-family: 'lato',sans-serif; font-weight: bold; color: white">Success Hits</th>
    <th bgcolor="#e41937" style="font-family: 'lato',sans-serif; font-weight: bold; color: white">Failure Hits</th>
  </tr>
  
  <c:forEach items="${rlist}" var="r">
  <tr>
  <td>${r.cpname}</td>
  <td>${r.service}</td>
  <td>${r.total}</td>
  <td>${r.success}</td>
  <td>${r.failure}</td>  
  </tr>
  </c:forEach>
  
</table>
</body>
</html>