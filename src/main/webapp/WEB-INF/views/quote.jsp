<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
  <meta charset="UTF-8">
  <title>Quote</title>
</head>
<body>
  <table width="100%">
    <tr>
      <td width="25%">${quoteView.getQuote().getName()} - score</td>
      <td>
      <a href="/?quoteId=${quoteView.getQuote().getId()}&valVisible=true">+</a>
      &nbsp;
      <a href="/?quoteId=${quoteView.getQuote().getId()}&valVisible=false">-</a>
      &nbsp;
      Posted by ${quoteView.getQuote().getCreateUser().getUserName()}
      </td>
      <td><a href="/quotesave?quoteid=${quoteView.getQuote().getId()}&quotename=${quoteView.getQuote().getName()}&quotecomm=${quoteView.getQuote().getComment()}">Change</a></td>
      <td><a href="/deletequote?quoteid=${quoteView.getQuote().getId()}">Delete</a></td>
    </tr>
    <c:if test = "${quoteView.isVisibleQuoteVaues()}">
    <tr>
      <td colspan="3">
        <jsp:include page="quotevalues.jsp"/>
      </td>
    </tr>
    </c:if>
  </table>
</body>
</html>