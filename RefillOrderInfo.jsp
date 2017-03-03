<%--
  Created by IntelliJ IDEA.
  User: po-yingyu
  Date: 2017-02-01
  Time: 11:31 AM
  Refill the OrderInfo,Clean the data from the bean, go to the OrderForm again.
--%>

<jsp:useBean id="lineItem" class="model.LineItem" scope="session"/>
<% lineItem.clearLineItem();%>
<jsp:forward page="DisplayPlaceOrderForm.jsp"/>


