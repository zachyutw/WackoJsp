<%--
  Created by IntelliJ IDEA.
  User: po-yingyu
  Date: 2017-02-01
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.

Delete the customer info then go back to index
--%>

<jsp:useBean id="customer" class="model.Customer" scope="session"/>
<%@ page import="database.Database"%>
<%! Database db = new Database();%>
<%=db.deleteLastRowData("Customer")%>
<% session.invalidate();%>
<jsp:forward page="index.jsp"/>


