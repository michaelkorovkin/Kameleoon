<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Quote</title>
</head>
<body>
<div align="center">
  <form action="/quotevaluesavesubmit", method="post">
    <input type="hidden" name="quoteid" value="${quoteValue.getQuote().getId()}"/>
    <br>
    <input type="hidden" name="quotevalueid" value="${quoteValue.getId()}"/>
    <br>
    <input name="quotevalue" value="${quoteValue.getValue()}"/>
    <br>
    <input type="submit" value="Save"/>
  </form>
</div>
</body>
</html>