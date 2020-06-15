<%--
  Created by IntelliJ IDEA.
  User: rene-
  Date: 6/3/2020
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Generated Password</h1>

    <form name="passwordGen" method="post" action="pasgen.jsp">
        <input type="text" name="passwd" placeholder="password" />
        <%
            String passwd =  request.getParameter("passwd");
        %>
        <input type="number" name="offset" placeholder="0"/>
        <%
            String offsetSTR = request.getParameter("offset");
        %>
        <button type="submit" class="btn">Generate Password</button>
    </form>

    <%
        String newPasswd = "";
        if(passwd == null){
            newPasswd = "password must not be empty ! please try again";
        }
        else if (offsetSTR.isEmpty()){
            newPasswd = "offset must not be empty ! please try again";
        }
        else {
            int offset = Integer.parseInt(offsetSTR);
            newPasswd = passwordGen(passwd,offset);
        }
    %>
    <%!
        public String passwordGen(String passwd,int offset){
            passwd = passwd.toLowerCase();
            System.out.println(passwd);
            System.out.println(offset);

            String new_passwd = "";
                for(int i = 0; i<passwd.length();i++) {
                    char currChar = passwd.charAt(i);
                    System.out.println(currChar);
                    if(currChar>='a' && currChar<='z') {
                        new_passwd += (char) (currChar + offset);
                    }
                    else{
                        new_passwd += currChar;
                    }
                    System.out.println(new_passwd);
                }

            return new_passwd;
        }
    %>
    Generated password is : <%= newPasswd %>


<% String method = request.getMethod(); %>
<h2><%= method %></h2>
<h2><%= application.getInitParameter("color") %></h2>
</body>
</html>