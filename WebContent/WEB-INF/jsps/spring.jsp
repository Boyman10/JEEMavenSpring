<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello dear <%= session.getAttribute("name")  %> , this is Spring!!
<p>
Request : <%= request.getAttribute("name") %>
</p>

<p>
Request using Expression Language : ${name}
</p>

<h3>Inner Links</h3>
<p><a href="${pageContext.request.contextPath}/jstl">Show current offers</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer">Create offer</a></p>

</body>
</html>