<%--
  Created by IntelliJ IDEA.
  User: po-yingyu
  Date: 2017-02-01
  Time: 3:23 PM
  Cofirm Customer Informationk, then save into Database.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="customer" class="model.Customer" scope="session"/>
<%@ page import="database.Database"%>
<%! Database db = new Database();%>
<%=db.saveCustomer(customer.getLname(), customer.getFname(),customer.getAddress(),customer.getEmail(),customer.getPhone())%>

<jsp:forward page="DisplayPlaceOrderForm.jsp"/>
