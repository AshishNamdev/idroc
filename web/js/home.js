/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var submitFlag = false;
function validate()
{
    //alert(submitFlag);
    if (submitFlag && document.getElementById("email").value !== "Not a valid email address")
        signup();
    else
    {
        alert("Please Fill All Required Fields Properly !!");
        return false;
    }  
}

function focusField(DOMObj)
{
    var msg = "Can't be empty" ;
    var value = DOMObj.value;
    DOMObj.style.color = "black";
    if(DOMObj.type === "password")
    {
        document.getElementById("emptyPasswordAlert").innerHTML = "";
        document.getElementById("emptyCnfPasswordAlert").innerHTML = "";
        setFiledBorderAndMessage(DOMObj,"","black");
    }
    else if (value === "" || value === msg)
    {
        setFiledBorderAndMessage(DOMObj,"","black");
        return false;
    }
    else
    {
        setFiledBorderAndMessage(DOMObj,"","black");
        return true;
    }
        
}
function checkFields(DOMObj)
{
    var msg = "Can't be empty" ;
    var value = DOMObj.value;
    var borderColor = "red";
    DOMObj.style.color = "black";
    if(DOMObj.type === "password")
    {
        if( ! isEmptyPassword(DOMObj))
        {
            submitFlag = false;
            return false;
        }
        else if(! comparePasswords(DOMObj))
        {
            submitFlag = false;
            return false;
        }
        else
        {
            submitFlag = true;
            return true;
        }
        
    }
    else if(DOMObj.id === "email")
    {
        if(! isValidEmail(value))
        {
            setFiledBorderAndMessage(DOMObj,"Not a valid email address",borderColor);
            submitFlag = false;
            return false;
        }
    }
    else if (value === "" || value === msg)
    {
        setFiledBorderAndMessage(DOMObj,msg,borderColor);
        submitFlag = false;
        return false;
    }
    else
    {
        submitFlag = true;
        return true;
    }
}
function setFiledBorderAndMessage(DOMObj , msg , borderColor)
{
    DOMObj.value = msg;
    DOMObj.style.border = "ridge";
    DOMObj.style.color = "red";
    DOMObj.style.borderColor = borderColor;
}

function comparePasswords(DOMObj)
{
    var ret = true;
    var password = document.getElementById("password");
    var confpassword = document.getElementById("confpassword");
    var emptyCnfPasswordAlert = document.getElementById("emptyCnfPasswordAlert");
    if(DOMObj.id === "confpassword" && (password.length !== confpassword.length || password.value !== confpassword.value))
    {
        emptyCnfPasswordAlert.innerHTML = "Passwords Do Not Match!!";
        ret = false;
    }
    else
        submitFlag = true;
   return ret;
      
}
function isEmptyPassword(DOMObj)
{
    var ret = true;
    var msg = "Password Can not be Empty !!"
    var alertObj = document.getElementById("emptyPasswordAlert");
    var value = DOMObj.value;
    if (DOMObj.id === "confpassword" && value === "")
    {
        msg = "Confirm Password can't be Empty";
        alertObj = document.getElementById("emptyCnfPasswordAlert");
        setFiledBorderAndMessage(DOMObj, "" , "red");
        alertObj.innerHTML = msg;
        ret = false;
    }   
    else if (DOMObj.id === "password" && value === "" )
    {
        setFiledBorderAndMessage(DOMObj, "" , "red");     
        alertObj.innerHTML = msg;
        ret =  false;
    }
    else
    {
        submitFlag = true;
        ret = true;
    }
    return ret;
}
function isValidEmail(email)
{
    var ret = false;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (email.match(mailformat))
    {
        ret = true;
    }
    return ret;
}
function signup()
{
    var xmlhttp;
    //var controller = "http://192.168.1.8:8084/idroc/Sgnup";
    var controller = "localhost:8084/idroc/Sgnup";
    
    //if(validate())
    //{
        if (window.XMLHttpRequest)
            xmlhttp = new XMLHttpRequest();
        else
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        xmlhttp.onreadystatechange = function()
        {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                document.getElementById("sResponse").innerHTML = xmlhttp.responseText;
            else
                alert(xmlhttp.status);
        };
    //}
    xmlhttp.open("POST",controller,true);
    xmlhttp.send();
}