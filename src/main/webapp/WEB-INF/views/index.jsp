<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
      <h1>Test page</h1>
    <link rel="stylesheet" href="/WEB-INF/views/css/main.css">
  </head>
<body>
  <table>
    <tr>
      <td colspan="2" width="100%">
        <span style="width: 25%">Profile</span>
        <span style="width: 25%">Top 10</span>
        <span style="width: 25%">Flop</span>
        <span style="width: 25%">Last</span>
      </td>
    </tr>
    <tr>
      <td width="100%">
        <c:set var="quoteView" value="${randomQuoteView}" scope = "request"/>
        <jsp:include page="quote.jsp"/>
      </td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td width="70%">
        Quotes
      </td>
      <td width="30%">
        <form action="">
        <div>
        <input value="login"/>
        </div>
        <div>
        <input value="password"/>
        </div>
        <div>
          Sign in
        </div>
        <div>
          <a href="/adduser">Create an account!</a>
        </div>
        </form>
      </td>
    </tr>
    <tr>
      <td>
        <a href="/quotesave?quoteid=-1&quotename=Name&quotecomm=Comment">Add</a>
      </td>
      <td>
        &nbsp;
      </td>
    </tr>
          <c:forEach items="${listQuoteViews}" var = "quoteView">
          <c:set var="quoteView" value="${quoteView}" scope = "request"/>
            <tr>
              <td colspan="2" class="qouteRow" width="100%">
                <jsp:include page="quote.jsp"/>
              </td>
            </tr>
          </c:forEach>


  </table>

</body>
</html>