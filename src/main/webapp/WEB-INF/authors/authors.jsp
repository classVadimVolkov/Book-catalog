<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Authors and Books</title>
</head>
<body>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Birthday</th>
        <th>Sex</th>
        <th>Title</th>
        <th>Publication year</th>
        <th>Publishing house</th>
    </tr>
    </thead>
    <c:forEach items="${authors}" var="author">
        <jsp:useBean id="author" type="by.volkov.testtask.model.Author"/>
        <tr>
            <td>${author.name}</td>
            <td>${author.surname}</td>
            <td>${author.surname}</td>
            <td>${author.birthday}</td>
        <c:forEach items="${author.books}" var="book">
            <jsp:useBean id="book" type="by.volkov.testtask.model.Book"/>
            <td>${book.title}</td>
            <td>${book.publicationYear}</td>
            <td>${book.publishingHouse}</td>
        </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
