<%-- 
    Document   : home
    Created on : Jan 21, 2016, 4:11:14 PM
    Author     : automation_dev
--%>

<!DOCTYPE html>
<html>
<head>
    <style>
        #wrap {
    width: 1400px;
    background: #EBEBEB none repeat scroll 0% 0%;
    margin: 0px auto;
    height: auto;
    box-shadow: 3px 3px 11px rgba(56, 50, 50, 0.70);
}
#header {
	background-color: #448C44;
        height:50px;
	color: white;
	text-align: center;
	padding: 5px;
}
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:500px;
    width:700px;
    float:left;
    padding:5px;
}
#section {
    width:350px;
    height:500px;
    float:left;
    padding:10px;
}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
    padding:5px;
}
    </style>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
  <script type="text/javascript">  

$(document).ready(function()  
{  
    $('.signup').hide();
    $('.admin').hide();
	
$("#admin").click(function()
{
$('.login').hide();
$('.signup').hide();
$('.admin').show();
});   
$("#sign").click(function()
{
$('.signup').show();
$('.login').hide();
$('.admin').hide();
});

$("#log").click(function()
{
$('.login').show();
$('signup').hide();
$('.admin').hide();
});

});  
   
</script>  
</head>
<body>
<div id="wrap">
<html xmlns="http://www.w3.org/1999/xhtml">
<body>
<head></head>
<div id="header">
 <a href="home.html">
<img src="logo.png" alt="IDROC" width="150" height="50" style="float: left"></a> 
<h1>Idroc Inventory Management</h1>
</div>

<div id="nav">
<h3> Idroc Web Portal</h3>

<p>IDROC is a web portal for managing and sharing the Inventories withing ateam or with the organisation.</p>
</div>
<div id="section">
	
	<!-- Login form -->
	<div class="login">
		<form name="login">
			<label>Username</label><br />
			<input type="text" name="username" class="input" id="username"/><br/>
			<label>Password</label><br />
			<input type="password" name="password" class="input" id="password"/><br/>
			<input type="submit" value="Login" class="button" />

			<a  href="#" onclick='("#sign").click(function()'>SignUp</a>
		</form>
		
	</div>
	<!-- end Login form -->
	
	<!-- Signup form -->
	<div class="signup">
		<form name="signup">
			<label>Name</label><br />
			<input type="text" name="name" class="input" id="name"/><br />
			<label>Email</label><br />
			<input type="text" name="email" class="input" id="email"/><br />
			<label>Enter password</label><br/>
			<input type="password" name="signup-password" class="input" id="signup-password" /><br/>
			<input type="submit" value="Create Account" class="button" />
			<a  href="#"  onclick='("#log").click(function()'>Return to Login</a>
		</form>
			</div>
	<!-- end LogSignup form -->

	<!-- admin form -->
	<div class="admin">
		<form name="admin">
			<label>Username</label><br />
			<input type="text" name="username" class="input" id="username"/><br/>
			<label>Password</label><br />
			<input type="password" name="password" class="input" id="password"/><br/>
			<input type="submit" value="Login" class="button" />

			<a  href="#" onclick='("#log").click(function()'>Return to Login</a>
		</form>
	</div>  
	<!-- end admin form -->
</div>

<div id="footer">
Copyright © AMD.com
</div>
</div>
</body> 
</html>