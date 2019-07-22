
<%@ include file="HeadSection.jsp" %>
<div class="welcomeuser">
    <span id="welcome">Welcome Admin</span>
    <span id="logout" style="float: right;">
        <a href="#logout">LOGOUT</a>
    </span>
</div>

<div class="container1">
    

    <div id="adminnav">
        <ul class="admin-sidebarnav">   
        <li class="admin-dashboard" >Dashboard</li>
        <li><a  onclick='enableIframe("add")'>Add User</a></li>
        <li><a  onclick='enableIframe("view")'>View User</a></li>
        </ul>        
    </div>

    <div id="adminframe">
       <!--  <iframe  src ="adduser.jsp"  id="iframe1" style="display: none;" frameborder="0">
        </iframe>
        <iframe  src ="ViewUSer.html" name="frame2" id="iframe2" style="display: none;" frameborder="0">
        </iframe> -->
    </div>

</div>
<script>

  function enableIframe(ch){ 
    // var doc = document.getElementById("iframe1");
    // doc.style.display="block";
    // var doc2 = document.getElementById("iframe2");
    console.log(ch);
    if(ch=="add")
    {
    var dd1 = document.getElementById("adminframe");
    dd1.innerHTML="<iframe  src='getadduser'  id='iframe1' frameborder='0'></iframe>";
    }
    else
    {
    var dd1 = document.getElementById("adminframe");
    dd1.innerHTML="<iframe  src='ViewUser.html'  id='iframe2' frameborder='0'></iframe>";
    } 

  }

  

</script>


</body>
</html>