<%@ include file="HeadSection.jsp" %>

<div class="welcomeuser">
    <span id="welcome">Welcome ${username}</span>
    <span id="logout" style="float: right;">
        <a href="Logout">LOGOUT</a>
    </span>
</div>

<div class="container1">
    

    <div id="adminnav">
        <ul class="admin-sidebarnav">   
        <li class="admin-dashboard" >Dashboard</li>
        <li><a onclick='enableIframe()'>View Report</a></li>
        </ul>        
    </div>


    <div id="adminframe">
        <!-- <iframe  src ="AddProduct.html" name="frame1" id="iframe1" style="display: none;" frameborder="0">
        </iframe>
        <iframe  src ="AddBusinessUser.html" name="frame2" id="iframe2" style="display: none;" frameborder="0">
        </iframe>
        <iframe  src ="EditBusinessUser.html" name="frame3" id="iframe3" style="display: none;" frameborder="0">
        </iframe> -->
    </div>

    

</div>

<script>

  function enableIframe(){
    //console.log(ch);

    var dd1 = document.getElementById("adminframe");
    dd1.innerHTML="<iframe src='ViewReport' id='iframe1' frameborder='0'></iframe>";
   
  }
    
</script>

</body>
</html>