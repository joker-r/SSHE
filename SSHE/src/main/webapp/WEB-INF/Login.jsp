<%@include file="HeadSection.jsp"%>


<div style="height: 20px; background-color: #E31837;">Welcome</div>
<div style="height: 30px; background-color: white;"></div>

<form action="Login" method="POST">
<div align="center" class="mx-auto" style="border: 2px solid #e41937; border-radius: 25px; height: 220px;
                                        width: 30%; padding-right: 10px;">
										
										
                                        <table style="width: 80%;">
                                            <tbody>
											<tr>
                                                <td colspan="2" style="width: 100%; border-bottom: 4px solid #e41937; color: #0075A1;
                                                    font-size: 26px; font-family: Segoe UI,arial; padding-bottom: 5px; margin-bottom: 20px;
                                                    padding-left: 20px; text-align: left;">
                                                    Log In 
                                                </td>
                                            </tr>
                                            <tr style="">
                                                <td style="height: 15px; width: 35%;">
                                                </td>
                                               
                                            </tr>
                                            <tr>
                                                <td style="width: 35%; height: 26px; text-align: left; padding-left: 20px;">
                                                    <span id="lblUsername" class="Loginlbl">User Name</span>
                                                </td>
                                                <td style="text-align: right; width: 65%; height: 26px;">
                                                    <input required name="username" type="text" id="tbUsername" class="LoginTxtBoxes" style="width:180px;">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="height: 8px; width: 35%;">
                                                </td>
                                               
                                            </tr>
                                            <tr>
                                                <td style="width: 35%; text-align: left; padding-left: 20px;">
                                                    <span id="lblPassword" class="Loginlbl">Password</span>
                                                </td>
                                                <td style="text-align: right; width: 65%;">
                                                    <input required name="password" type="password" id="tbPassword" class="LoginTxtBoxes" style="width:180px;">
                                                 
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="height: 8px; width: 35%;">
                                                </td>
                                               
                                            </tr>
                                            <tr>
                                                <td style="width: 35%; height: 24px; padding-right: 20px; text-align: left; vertical-align: bottom;">
                                                   
												   </td>
                                                <td style="text-align: right; width: 30%; height: 24px;">
                                                    &nbsp;<input class="btn btn-danger" type="submit" name="btnLogin" value="Login" id="btnLogin" class="LoginBtn">
                                                </td>
                                            </tr>
                                             <tr>
                                                <td colspan="2" style="width: 100%; color: #FF0000;
                                                    font-size: 26px; font-family: Segoe UI,arial; padding-bottom: 5px; margin-bottom: 20px;
                                                    padding-left: 20px; text-align: center;">${msg}</td>
                                               
                                            </tr>
                                        </tbody>
								        </table>
                                    </div>
                                    						
</form>									
</body>
</html>										
						