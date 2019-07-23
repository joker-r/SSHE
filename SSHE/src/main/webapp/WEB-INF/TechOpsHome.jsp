<%@include file="HeadSection.jsp" %>

<div class="welcomeuser">
    <span id="welcome">Welcome TechOps</span>
    <span id="logout" style="float: right;">
        <a href="#logout">LOGOUT</a>
    </span>
</div>

<div class="container1">
    

    <div id="adminnav">
        <ul class="admin-sidebarnav">   
        <li class="admin-dashboard" >Dashboard</li>
        <li><a onclick='enableIframe("addprod")'>Add Product</a></li>
        <li><a onclick='enableIframe("add")'>Add Business User</a></li>
        <li><a onclick='enableIframe("edit")'>Edit Business User</a></li>
        </ul>        
    </div>


    <div id="adminframe">
        <!-- <iframe  src ="AddProduct.html" name="frame1" id="iframe1" style="display: none;" frameborder="0">
        </iframe>
        <iframe  src ="getaddbusinessuser" name="frame2" id="iframe2" style="display: none;" frameborder="0">
        </iframe>
        <iframe  src ="EditBusinessUser.html" name="frame3" id="iframe3" style="display: none;" frameborder="0">
        </iframe> -->
    </div>
    
</div>

<script>

  function enableIframe(ch){

    //console.log(ch);

    if(ch=="addprod")
    {
    var dd1 = document.getElementById("adminframe");
    dd1.innerHTML="<iframe src='AddProduct.html' id='iframe1' frameborder='0'></iframe>";
    }
    else if(ch=="add")
    {
    var dd2 = document.getElementById("adminframe");
    dd2.innerHTML="<iframe src='getaddbusinessuser' id='iframe2' frameborder='0'></iframe>";
    }    
    else
    {
    var dd3 = document.getElementById("adminframe");
    dd3.innerHTML="<iframe src='EditBusinessUser.html' id='iframe3' frameborder='0'></iframe>";
    }


  }
    

</script>

</body>
</html>