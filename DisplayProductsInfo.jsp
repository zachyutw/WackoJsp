<%--
  Created by IntelliJ IDEA.
  User: po-yingyu
  Date: 2017-02-17
  Time: 9:58 AM
  Display the product Info
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="database.Database"%>
<%! Database db = new Database();%>
<html>
<head>
</head>
<BODY>
    <h2>This are our Items</h2>
<FORM >
   <table id="product_table" border="1">
    <%=db.getProductInventary()%>
    </table>
   <P></P>
</FORM>
    <a href="index.jsp"><button>Go Back Home Page</button></a>
</BODY>
</HTML>



