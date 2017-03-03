<%--
  Created by IntelliJ IDEA.
  User: po-yingyu
  Date: 2017-02-01
  Time: 11:00 AM
  Display the Customer Form, Keep preview's input
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="customer" class="model.Customer" scope="session"/>
<html>
<head>
    <title>WACKO Furniture</title>
</head>

<BODY>
<% if(model.getLname()==null) { %>
<FORM METHOD=POST ACTION="SaveCustomerInfo.jsp">

    Please enter your last name! <INPUT TYPE=TEXT NAME=lname SIZE=20 required><BR>
    Please enter your first name! <INPUT TYPE=TEXT NAME=fname SIZE=20 required><BR>
    Please enter your address! <INPUT TYPE=TEXT NAME=address SIZE=20 required><BR>
    Please enter your e-mail! <INPUT TYPE=TEXT NAME=email SIZE=20 required><BR>
    Please enter your phone number! <INPUT TYPE=TEXT NAME=phone SIZE=20 required><BR>
    <P><INPUT TYPE=SUBMIT></P>
</FORM>
<% }else{ %>
        <FORM METHOD=POST ACTION="SaveCustomerInfo.jsp">

            Please enter your last name! <INPUT TYPE=TEXT NAME=lname SIZE=20 value="<%=model.getLname()%>" required><BR>
            Please enter your first name! <INPUT TYPE=TEXT NAME=fname SIZE=20 value="<%=model.getFname()%>" required> <BR>
            Please enter your address! <INPUT TYPE=TEXT NAME=address SIZE=20 value="<%=model.getAddress()%>" required><BR>
            Please enter your e-mail! <INPUT TYPE=TEXT NAME=email SIZE=20 value="<%=model.getEmail()%>" required><BR>
            Please enter your phone number! <INPUT TYPE=TEXT NAME=phone SIZE=20 value="<%=model.getPhone()%>" required><BR>
    <P><INPUT TYPE=SUBMIT></P>
</FORM>
<% } %>

</BODY>
</HTML>
