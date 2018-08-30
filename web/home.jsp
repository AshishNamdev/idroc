<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Inventory Management</title>
<link href="style/home.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/home.js"></script>

</head>

<body>

<div id="container">

     <%@include file="header.html"%>
     
  <div class="content">
  <div> 
  
  <div> </div>
  <div> </div>
  
  </div>
  
  <div class="left-content" id="sub_container">
    <marquee scrollamount="5"><font color='#990000'> <h1> Welcome to IDROC</h1> </font></marquee>
      <div id="d1" style="display:block">   
          <p><strong>IDROC Web Portal</strong></p>
          <p> Idroc is an abbreviation of Inventory record (where I is inventory and droc is reverse record</p>
          <p> where you manage the inventory of your day today hardware and sharing them across the team through a centralized database</p> 
          <ul>  
          </ul>
      </div>
      <br/><br/><br/>
      <br/><br/><br/>
      <br/><br/><br/>
    </div>
 <!----left-div ends-----> 
<div class="divsec" id="login" >
    
    <form ACTION="/index.php" METHOD="POST" name="login">
    <table width="98%" border="0">
        <tr> <h1>Login</h1></tr> 
         <tr>
            <td width="45%" align="right" valign="top">
       	   <span  style="color:#5094BA"> Login Name</span></td>
             <td width="55%" align="left"><input type="text" name="username" id="username" class="inputform" />
    			
           </td>
         </tr>
          <tr>
          	<td align="right" valign="top">
             <span  style="color:#5094BA"> Password &nbsp; </span></td>
             <td align="left"><input type="text" value="" maxlength="10"  class="inputform"  name="mobile" id="mobile">
    		</td>
           </tr>
           <tr>
           		<td colspan="2" align="middle">
                    <input name="submit" type="submit"  style="margin-left:20px;"value="Log In" />
                    <p style="height:18px; color:#900; padding-left:20px;" class="textsmall">
					                                         </p>
                </td>
                <td width="0%">&nbsp;</td>
           </tr>
           <tr>
           		<td colspan="2"  align="left" style="padding-left: 20px; " >
                <span  style="float:left"><a href=""><strong>Sign Up</a></strong></span>
                <span  style="float:right"><a href=""><strong>Admin Login</a></strong></span>
                </td>
           </tr>
   </table>
    </form> </div> 
<!---- Login form ends ----->
<div class="divsec" id="signup" >
    <!--<form ACTION="" METHOD="POST" name="signup">-->
        <table width="98%" border="0">
            <tr>
                <h1>Sign Up</h1>
            </tr>
            <tr>
                <td>
                    <span id='sResponse'></span>
                    <!--<span class ='sResponse'></span>-->
                </td>
            </tr>
            <tr>
                <td width="45%" align="right" valign="top">
                    <span  style="color:#5094BA">First Name<span class="astric">*</span></span>
                </td>
                <td width="55%" align="left"><input type="text" name="f_name" id="f_name" class="inputform" onfocus="return focusField(this)" onblur="return checkFields(this)"/></td>
            </tr>
            <tr>
                <td width="45%" align="right" valign="top">
                    <span  style="color:#5094BA">Middle Name</span>
                </td>
                <td width="55%" align="left"><input type="text" name="m_name" id="m_name" class="inputform" onfocus="return focusField(this)" /></td>
            </tr>
            <tr>
                <td width="45%" align="right" valign="top">
                    <span  style="color:#5094BA">Last Name<span class="astric">*</span></span>
                </td>
                <td width="55%" align="left"><input type="text" name="l_name" id="l_name" class="inputform" onfocus="return focusField(this)" onblur="return checkFields(this)"/></td>
            </tr>
            <tr>
                <td width="45%" align="right" valign="top">
                    <span  style="color:#5094BA">Email<span class="astric">*</span></span>
                </td>
                <td width="55%" align="left"><input type="text" name="email" id="email" class="inputform" onfocus="return focusField(this)" onblur="return checkFields(this)"/></td>
            </tr>
            <tr>
                <td align="right" valign="top">
                    <span  style="color:#5094BA">Password<span class="astric">*</span></span>
                </td>
                <td align="left"><input type="password" value="" maxlength="10"  class="inputform"  name="password" id="password" onfocus="return focusField(this)" onblur="return checkFields(this)"/></td>
            </tr>
            <tr>
                <td></td>
                <td><span class="passwordAlert" id="emptyPasswordAlert"></span></td>
            </tr>
            <tr>
                 <td align="right" valign="top">
                    <span  style="color:#5094BA"> Confirm Password<span class="astric">*</span></span>
                 </td>
                 <td align="left"><input type="password" value="" maxlength="10"  class="inputform"  name="confpassword" id="confpassword" onfocus="return focusField(this)"  onblur="return checkFields(this)" /></td>
            </tr>
            <tr>
                <td></td>
                <td><span class="passwordAlert" id="emptyCnfPasswordAlert"></span></td>
            </tr>
            <tr>
                <td colspan="2" align="middle">
                    <!--<input name="submit" type="submit"  style="margin-left:20px;"value="Signup" onclick="return isEmpty()"/> -->
                    <!--<input type="image" src="images/signup.png" onclick = "return validate()"/>-->
                    <button onclick = "return validate()"><img src="images/signup.png"  /></button>
                    
                </td>
                <td width="0%">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2"  align="left" style="padding-left: 20px; " >
                    <span  style="float:left"><a href=""><strong>Login</a></strong></span>
                    <span  style="float:right"><a href=""><strong>Admin Login</a></strong></span>
                </td>
            </tr>
        </table>
    <!--</form> -->
</div>
<!------ Sign Up form ends ------>

<div class="divsec" id="adminlogin" >

    <form ACTION="/index.php" METHOD="POST" name="login">
        <table width="98%" border="0">
            <tr> <h1>Login</h1></tr>
            <tr>
                            <td width="45%" align="right" valign="top">
               <span  style="color:#5094BA">Admin Login</span></td>
                 <td width="55%" align="left"><input type="text" name="username" id="username" class="inputform" />

               </td>
            </tr>
              <tr>
                    <td align="right" valign="top">
                 <span  style="color:#5094BA"> Password &nbsp; </span></td>
                 <td align="left"><input type="text" value="" maxlength="10"  class="inputform"  name="mobile" id="mobile">
                    </td>
               </tr>
               <tr>
                            <td colspan="2" align="middle">
                        <input name="submit" type="submit"  style="margin-left:20px;"value="Log In" />
                        <p style="height:18px; color:#900; padding-left:20px;" class="textsmall">
                                                                                     </p>
                    </td>
                    <td width="0%">&nbsp;</td>
               </tr>
               <tr>
                            <td colspan="2"  align="left" style="padding-left: 20px; " >
                    <span  style="float:left"><a href=""><strong>Sign Up</a></strong></span>
                    <span  style="float:right"><a href=""><strong>Login</a></strong></span>
                    </td>
               </tr>
       </table>
    </form> 
<!----- Admin login form ends ------>
</div>
 </div>
 <%@include file="footer.html"%>
</body>

</html>