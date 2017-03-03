<%-- 
    Document   : saveOrderProducts
    Created on : 19-Feb-2017, 1:47:52 AM
    Author     : po-yingyu
    Save the ordered Products' quantaty.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="lineItem" class="model.LineItem" scope="session"/>
<jsp:setProperty name="lineItem" property="selectedProductQty" param="selectedProductQty"/>
<jsp:forward page="DisplayOrderInfo.jsp"/>

 