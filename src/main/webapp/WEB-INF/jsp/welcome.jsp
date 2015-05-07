<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bwertr - Welcome!</title>
</head>
<body>
<h1>Welcome to Bwertr!</h1>
<p>This presentation has been rated <span id="numberOfRatings">${numberOfRatings}</span> times.</p>
<form action="/" method="post">
    <label for="rating">Please rate</label>
    <select name="rating" id="rating">
        <c:forEach items="${possibleRatings}" var="rating">
            <option value="${rating}">${rating}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Rate now!">
</form>
</body>
</html>
