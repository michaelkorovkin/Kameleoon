<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Quote save</title>
</head>
<body>
<div align="center">
  <form action="quotesavesubmit" method="post">
    <input type="hidden" name="quoteid" value="${quote.getId()}"/>
    <br/>
    <input name="quotename" value="${quote.getName()}"/>
    <br/>
    <input name="quotecomm" value="${quote.getComment()}"/>
    <br/>
    <input type="submit" value="Save" >
  </form>
</div>

</body>
</html>