<%@ include file="HeadSection.jsp" %>

<div class="welcomeuser">
    <span id="welcome">Welcome Admin</span>
    <span id="logout" style="float: right;">
        <a href="#logout">LOGOUT</a>
    </span>
</div>

<div class="container1">


    <div id="dashboard"><p>DASHBOARD</p></div>
    
    <div class="adminnav" >
        <a href="#adduser" onclick='enableIframe()'>ADD USER</a><br/>
        <a href="#viewuser">VIEW USER</a><br/>
    </div>

    <div class="frame">
        <iframe src ="C:\Users\comviva\Desktop\AddUser.html" name="function" id="iframe" style="display: none;" frameborder="0">
        
        </iframe>
    </div>

    

</div>
<script>

  function enableIframe(){

      console.log("hello");
    var doc = document.getElementById("iframe");
  doc.style.display="block";

  }
  
  

</script>


</body>
</html>