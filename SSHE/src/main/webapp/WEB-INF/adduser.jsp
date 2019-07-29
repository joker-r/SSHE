<html>
<head>
<link href="css/admin.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="adduser" method="POST">
		<div class="adduserdetails">
			<table id="addusertable" class="col-md-5 mx-auto" cellpadding='20px'
				cellspacing='10px'>
				<tbody
					style="display: flex; flex-direction: column; align-items: center;">
					<tr>
						<td>Username</td>
						<td><input type="text" pattern="^[a-zA-Z][a-zA-Z0-9]{2,9}$"
							title="first character should be alphabet followed by 2-9 alphanumeric characters"
							required name="username"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" pattern="^.{5,15}$"
							title="min 5 and max 15 characters" required name="password"></td>
					</tr>
					<tr>
						<td>Usertype</td>
						<td><input type="text" name="usertype" value="Techops"
							readonly></td>
					</tr>
					<tr>
						<td><input type="submit" class="btn btn-danger" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>