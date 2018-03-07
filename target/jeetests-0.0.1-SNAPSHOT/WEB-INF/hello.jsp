<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<p>Hello Guys !</p>
<p>
    <%
        //String name = (String) request.getAttribute("name");
    	//out.println("Bonjour"); 

    %>
    Hello ${author.firstnam}
</p>
 <p>${ author.active ? 'Vous êtes très actif !' : 'Vous êtes inactif !' }</p>

<p>
    <%
        for (int i = 0 ; i < 20 ; i++) {
            out.println("Une nouvelle ligne !<br />");
        }
    %>
</p>
</body>
</html>