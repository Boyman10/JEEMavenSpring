<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>

<c:forEach var="row" items="${offers}">
    Email ${row.email}<br/>
    Name ${row.name}<br/>
    Name ${row.text}<br/>
</c:forEach>

  </body>
</html>