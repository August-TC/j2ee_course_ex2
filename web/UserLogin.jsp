<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF">
<h1 align="center">User Login</h1>
<hr>
<p><b>User information:</b></p>
<%
    String name="",pw="",checked=null;
    Cookie cookies[] = request.getCookies();
    if (cookies != null)
    {
        for (int i = 0; i < cookies.length; i++)
        {
            switch (cookies[i].getName())
            {
                case "name":
                    name = cookies[i].getValue();
                    break;
                case "pw":
                    pw = cookies[i].getValue();
                    break;
                case "store":
                    checked = cookies[i].getValue();
                    break;
            }
        }
        if (checked == null)
        {
            name = "";
            pw = "";
        }
    }
%>
<form method="post" action="Login.do">
  <table width="500" border="0" cellspacing="0" cellpadding="0">
    <tr> 
      <td width="100"> 
        User name:
      </td>
      <td width="431">
	  	<input type="text" name="name" value="<%=name%>">
	  </td>
    </tr>
    <tr> 
      <td width="100">
        Password:
      </td>
      <td width="431">
      	<input type="password" name="password" value="<%=pw%>">
      </td>
    </tr>
      <tr>
          <td></td>
          <td>
              <input type="checkbox" name="store" value="checked">remember me
          </td>
      </tr>
  </table>
    <hr>
  <p>
    <input type="submit" name="btn_submit" value="Login">
    <input type="reset" name="btn_reset" value="Reset">
  </p>
</form>
<p>&nbsp;</p>
</body>
</html>