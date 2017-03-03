<%--
  Created by IntelliJ IDEA.
  User: po-yingyu
  Date: 2017-02-17
  Time: 9:58 AM
  Display the Form to let user to multiply select products
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="customer" class="model.Customer" scope="session"/>
<%@ page import="database.Database"%>
<%! Database db = new Database();%>
<jsp:setProperty name="customer" property="id" value='<%=db.getLastData("customerId","Customer","customerId")%>' />
<html>
<head>

</head>

<BODY>
    <h2>Hello <%=customer.getFname()%> let's begin our first shopping</h2>
    <h2>Select Items and Choose Quantity</h2>
<FORM method="Post"Action="SaveSelectedProductIdController.jsp" >
   <table id="product_table" border="1">
    <%=db.getProductInfo()%>
    </table>
   <P><INPUT TYPE="SUBMIT" value="Check"></P>
</FORM>

   

</BODY>
</HTML>



