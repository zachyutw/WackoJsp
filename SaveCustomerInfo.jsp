<%--
  Created by IntelliJ IDEA.
  User: po-yingyu
  Date: 2017-02-01
  Time: 11:31 AM
  Save Customer Info to DB
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="customer" class="model.Customer" scope="session"/>
<jsp:setProperty name="customer" property="*"/>
<jsp:forward page="DisplayCustomerInfo.jsp"/>


