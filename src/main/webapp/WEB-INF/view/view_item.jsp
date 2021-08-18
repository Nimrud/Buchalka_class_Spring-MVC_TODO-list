<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.example.util.Mappings" %>
<html>
<head>
    <title>TODO Items - View Item</title>
</head>
<body>
    <div align="center">

        <table border="1" cellpadding="5">
            <caption><h2>TODO Item Full Info</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Deadline</th>
                <th>Details</th>
            </tr>

            <tr>
                <td><c:out value="${todoItem.id}"/></td>
                <td><c:out value="${todoItem.title}"/></td>
                <td><c:out value="${todoItem.deadline}"/></td>
                <td><c:out value="${todoItem.details}"/></td>
            </tr>

        </table>

        <br/>

        <c:url var="items" value="${Mappings.ITEMS}"/>
        <a href="${items}">Back to TODO Items List</a>

    </div>
</body>
</html>