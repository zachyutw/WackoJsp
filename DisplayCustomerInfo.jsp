<%--
  Created by IntelliJ IDEA.
  User: po-yingyu
  Date: 2017-02-01
  Time: 11:00 AM
  Display the Customer Info from Form. Confirm: save to db, Cancel: go to index and destory session, Back to Form: make users to change form
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="customer" class="model.Customer" scope="session"/>
<html>
<head>
    <title>WACKO Furniture</title>
</head>
<body>
<h1>Mr. <%=customer.getLname() %>, This is your personal info below </h1>
<table>
    <tr>
        <td>First name</td>
        <td><%=customer.getFname() %></td>
    </tr>
    <tr>
        <td>Last name</td>
        <td><%=customer.getLname() %></td>
    </tr>
    <tr>
        <td>E-mail</td>
        <td><%=customer.getEmail() %></td>
    </tr>
    <tr>
        <td>Address</td>
        <td><%=customer.getAddress() %></td>
    </tr>
    <tr>
        <td>Phone number</td>
        <td><%=customer.getPhone() %></td>
    </tr>
</table>
<div>
    <div><a href="ConfirmCustomerInfo.jsp"><button>Confirm</button></a>
    <a href="CancelCustomerInfo.jsp"><button>Cancel</button></a>
    <a href="DisplayCustomerForm.jsp"><button>Back to Form</button></a></div>
</div>
</body>
</html>
