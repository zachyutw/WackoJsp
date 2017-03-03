<%-- 
    Document   : saveOrderProducts
    Created on : 19-Feb-2017, 1:47:52 AM
    Author     : po-yingyu
    Save the ordered Products to Bean
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="lineItem" class="model.LineItem" scope="session"/>
<jsp:setProperty name="lineItem" property="selectedProductId" param="selectedProductId"/>
<jsp:forward page="DisplayOrderQtyForm.jsp"/>


 