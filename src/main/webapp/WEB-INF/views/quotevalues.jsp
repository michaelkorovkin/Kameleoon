<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<table>
  <tr>
    <th>Quote value</th>
    <th>Quote value creation date and time.</th>
    <th>&nbsp;</th>
    <th>&nbsp;</th>
  </tr>
  <tr>
    <td colspan="2"><a href="/quotevalusave?quoteid=${quoteView.getQuote().getId()}&quotevalueid=-1&quoteid$&quotevalue=999">Add</a></td>
  </tr>
  <c:forEach items="${quoteView.getQuote().getQuoteValues()}" var = "quoteValue">
  <tr>
    <td>
      ${quoteValue.getValue()}
    </td>
    <td>
        ${quoteValue.getValueDate()}
    </td>
    <td><a href="/quotevalusave?quotevalueid=${quoteValue.getId()}&quoteid=${quoteValue.getQuote().getId()}&quotevalue=${quoteValue.getValue()}">Change</a></td>
    <td><a href="/deletequotevalue?quotevalueid=${quoteValue.getId()}">Delete</a> </td>
  </tr>
  </c:forEach>
</table>
</body>
</html>